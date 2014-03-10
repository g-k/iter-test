# iter-test

Test using iterate to simulate consuming APIs that require the next
request to depend on the previous response.

## Installation

Download from http://example.com/FIXME.

## Usage

FIXME: explanation

    $ java -jar iter-test-0.1.0-standalone.jar [args]

## Options

query - query to use

## Examples

```
$ lein run chicken
Reflection warning, /tmp/form-init1637135119634326599.clj:1:911 - call to invokeStaticMethod can't be resolved.
Reflection warning, clj_http/multipart.clj:26:4 - call to org.apache.http.entity.mime.content.FileBody ctor can't be resolved.
fetching hrefs for pages for query chicken
First query {:method :get, :url http://google.com, :save-request true, :query-params {:q chicken, :start 0}}
200 http://www.google.com/?q=chicken&start=0 in 461 ms
query-params {:q chicken, :start 0}
(href="/search? href="http://www.google.com/imghp?q=chicken&hl=en&tab=wi href="http://maps.google.com/maps?q=chicken&hl=en&tab=wl href="https://play.google.com/?q=chicken&hl=en&tab=w8 href="http://www.youtube.com/?q=chicken&tab=w1 href="http://news.google.com/nwshp?hl=en&tab=wn href="https://mail.google.com/mail/?tab=wm href="https://drive.google.com/?tab=wo href="http://www.google.com/intl/en/options/ href="http://www.google.com/history/optout?hl=en href="/preferences?hl=en href="https://accounts.google.com/ServiceLogin?hl=en&continue=http://www.google.com/%3Fq%3Dchicken%26start%3D0 href="/advanced_search?hl=en&amp;authuser=0 href="/language_tools?hl=en&amp;authuser=0 href="/intl/en/ads/ href="/services/ href="https://plus.google.com/116899029375914044550 href="/intl/en/about.html href="/intl/en/policies/)
next query {:method :get, :url http://google.com, :save-request true, :query-params {:q chicken, :start 10}}
200 http://www.google.com/?q=chicken&start=10 in 295 ms
query-params {:q chicken, :start 10}
(href="/search? href="http://www.google.com/imghp?q=chicken&hl=en&tab=wi href="http://maps.google.com/maps?q=chicken&hl=en&tab=wl href="https://play.google.com/?q=chicken&hl=en&tab=w8 href="http://www.youtube.com/?q=chicken&tab=w1 href="http://news.google.com/nwshp?hl=en&tab=wn href="https://mail.google.com/mail/?tab=wm href="https://drive.google.com/?tab=wo href="http://www.google.com/intl/en/options/ href="http://www.google.com/history/optout?hl=en href="/preferences?hl=en href="https://accounts.google.com/ServiceLogin?hl=en&continue=http://www.google.com/%3Fq%3Dchicken%26start%3D10 href="/advanced_search?hl=en&amp;authuser=0 href="/language_tools?hl=en&amp;authuser=0 href="/intl/en/ads/ href="/services/ href="https://plus.google.com/116899029375914044550 href="/intl/en/about.html href="/intl/en/policies/)
next query {:method :get, :url http://google.com, :save-request true, :query-params {:q chicken, :start 20}}
200 http://www.google.com/?q=chicken&start=20 in 303 ms
query-params {:q chicken, :start 20}
(href="/search? href="http://www.google.com/imghp?q=chicken&hl=en&tab=wi href="http://maps.google.com/maps?q=chicken&hl=en&tab=wl href="https://play.google.com/?q=chicken&hl=en&tab=w8 href="http://www.youtube.com/?q=chicken&tab=w1 href="http://news.google.com/nwshp?hl=en&tab=wn href="https://mail.google.com/mail/?tab=wm href="https://drive.google.com/?tab=wo href="http://www.google.com/intl/en/options/ href="http://www.google.com/history/optout?hl=en href="/preferences?hl=en href="https://accounts.google.com/ServiceLogin?hl=en&continue=http://www.google.com/%3Fq%3Dchicken%26start%3D20 href="/advanced_search?hl=en&amp;authuser=0 href="/language_tools?hl=en&amp;authuser=0 href="/intl/en/ads/ href="/services/ href="https://plus.google.com/116899029375914044550 href="/intl/en/about.html href="/intl/en/policies/)
next query {:method :get, :url http://google.com, :save-request true, :query-params {:q chicken, :start 30}}
done
```
