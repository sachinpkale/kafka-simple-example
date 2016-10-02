# App

A simple Clojure app illustrating very basic use case of produce and consume methods of Kafka. 

## Usage

1.  Start Kafka on your local machine as instructed in first 2 steps in [here](http://kafka.apache.org/quickstart.html).
2.  Create a topic using following command:
    * `bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test`
3.  That is the required setup! Now run `produce` method multiple times to produce some random messages.
4.  Run `consume` to fetch 2 messages at a time.

## License

Distributed under the Eclipse Public License either version 1.0
