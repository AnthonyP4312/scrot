(ns scrot.core
  (:gen-class)
  (:require [clj-discord.core :as d]
            [clojure.string :as s]))

(defonce token (.trim (slurp "token.txt")))
(defonce scrot (s/split-lines (slurp "scrot.txt")))

(def random-scrot
  [type data]
  (d/answer-command data "alf" (rand-nth scrot)))

(defn -main
  [& args]
  (d/connect {:token token
              :functions {"MESSAGE_CREATE" [random-scrot]
                          "MESSAGE_UPDATE" [random-scrot]}}))

