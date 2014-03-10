(ns iter-test.core
  (:gen-class)
  (:require [clj-http.client :as client]))

; simulate an API with a page or result limit
; could also read until error
(def MAX-OFFSET 30)

(def DELAY 3) ; time between requests in ms

(defn run-query
  [query-map]
  (client/request query-map))

(defn google-query
  "map for a google query to clj-http"
  [query start]
  {:method :get
   :url "http://google.com"
   :save-request true
   :query-params {:q query
                  :start start}
   })

(defn parse-hrefs
  "example instead use a real parser for a real API"
  [body]
  (re-seq #"href=\"[^\"]+" body))

(defn request-next
  ([query]
     "Run the first query"
     (let [query-map (google-query query 0)]
       (println "First query" query-map)
       {:response (run-query query-map)
        :query-map query-map}))
  ([query last-request]
     "Generate the next query from the previous response and run it if applicable"
     (let [_ (println "query-params" (-> last-request
                                         :query-map
                                         :query-params))
           _ (println (-> last-request :response :body parse-hrefs))
           plus-ten #(+ 10 %)
           next-page (-> last-request
                         :query-map
                         :query-params
                         :start
                         plus-ten)
           query-map (google-query query next-page)]
       (println "next query" query-map)
       (if (>= next-page MAX-OFFSET)
         nil
         {:response (run-query query-map)
          :query-map query-map}))))

(defn fetch-pages
  "Use iterate as a stateful generator since we need the last response to generate the next request must call next-request with doseq"
  [query]
  (let [get-next-page (partial request-next query)]
    (doseq [response (take-while (complement nil?)
                                 (iterate get-next-page
                                          (get-next-page)))]

      ; simulate max (could also read rate limit headers)
      (let [request-time (-> response :response :request-time)
            sleep-time (max (- DELAY request-time) 0)]

        (println (-> response :response :status)
                 (-> response :response :request :http-url)
                 "in" request-time "ms")

        (if (> 0 sleep-time)
          (do (println "sleeping for" sleep-time "ms")
              (Thread/sleep sleep-time))))))

  (println "done"))

(defn -main
  [query & args]
  (println "fetching hrefs for pages for query" query)
  (fetch-pages query))
