(defproject +project+ "0.0.1-SNAPSHOT"
  :description      "TODO: Write project description"
  :main             +project+.core
  :dependencies     [[org.clojure/clojure         "1.2.0"]
		     [org.clojure/clojure-contrib "1.2.0"]
		     [enlive                      "1.0.0-SNAPSHOT"]
		     [net.cgrand/moustache        "1.0.0-SNAPSHOT"]
                     [ring/ring-core              "0.3.0"]
		     [ring/ring-jetty-adapter     "0.3.0"]
		     [ring/ring-devel             "0.3.0"]
                     [mysql/mysql-connector-java  "5.1.6"]
                     [clojureql                   "1.1.0-SNAPSHOT"]
		     [javax.mail/mail             "1.4.2"]
                     [log4j                       "1.2.15"
                      :exclusions [javax.mail/mail
                                   javax.jms/jms
                                   com.sun.jdmk/jmxtools
                                   com.sun.jmx/jmxri]]]
  :dev-dependencies [[swank-clojure               "1.2.0"]]
  :jar-files        [["resources" ""]]
  :war-files        [["resources" ""]])


