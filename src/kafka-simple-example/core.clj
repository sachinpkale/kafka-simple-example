(ns kafka-simple-example.core
  (:require [clj-kafka.new.producer :as p]
            [clj-kafka.consumer.zk :as zk]
            [clj-kafka.core :as ckc]
            [clj-kafka.admin :as cfa]))

(def config {"zookeeper.connect" "localhost:2181"
             "group.id" "test-group"
             "auto.offset.reset" "smallest"
             "auto.commit.enable" "true"
             "consumer.timeout.ms" "5000"})

(def prdcr (p/producer {"bootstrap.servers" "localhost:9092"} (p/byte-array-serializer) (p/byte-array-serializer)))

(def topic "test")


(defn check-topic
  [tname]
  (cfa/topic-exists? (cfa/zk-client "localhost:2181") tname))

(defn produce
  []
  (p/send prdcr (p/record topic (.getBytes (str "hello! " (rand 100000))))))

(defn consume
  []
  (ckc/with-resource [c (zk/consumer config)]
    zk/shutdown
    (doall(take 2 (zk/messages c topic)))))
