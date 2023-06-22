(ns server.core
  (:require [org.httpkit.server :refer [run-server]]))

(defn app [req]
  {:status 200
   :body "Hello, World!"})

(def server (atom nil))

(defn stop-server []
 (when-let [s @server]
   (.stop s)
   (reset! server nil)))

(defn start-server
  "Start the server on port `port` or `8080`."
  ([] (start-server 8080))
  ([port] (do (stop-server)
              (reset! server (run-server #'app {:port port})))))

(defn -main [& args]
  (start-server))

(comment

  (start-server)
  (stop-server)


  )
