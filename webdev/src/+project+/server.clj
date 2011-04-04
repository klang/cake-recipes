(ns +project+.server
  (:use net.cgrand.enlive-html
	net.cgrand.moustache
	ring.util.response
        [ring.middleware params multipart-params file reload session]
	[clojure.contrib logging]
        [+project+.templates])
  (:require [clojureql.core :as cql]
            [clojure.contrib.io :as io])
  (:import [java.io File]))

                                        ; Globals

(declare routes)
(declare run-jetty)

                                        ; Initialization

(def production?
  (= "tomcat" (System/getProperty "user.name")))

(def development?
  (not production?))

(eval `(when ~(not (or production? *compile-files*))
         (use '~'ring.adapter.jetty)
         (doto (Thread. #((ns-resolve '~'ring.adapter.jetty '~'run-jetty) #'routes {:port 8080}))
           .start)))

                                        ; Middlewares

(defn wrap-if [handler pred middleware & args]
  (if pred
    (apply middleware handler args)
    handler))

                                        ; Routes

(def +project+-application
   (app
    ; (wrap-if development? wrap-reload '[+project+.templates])
    ; (wrap-session)
    (wrap-if development? wrap-file "resources")
    [""]             (-> "Hello, world!" response constantly)
    ))

(def routes
   (if development?
     +project+-application
     (app ["+project+" &]
          +project+-application)))