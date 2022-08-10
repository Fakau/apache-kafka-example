## Apache-kafka-example

### Download apache kafka
https://kafka.apache.org/quickstart


### Start the ZooKeeper service
Note: Soon, ZooKeeper will no longer be required by Apache Kafka.
Open a terminal session and run:
$ bin/zookeeper-server-start.sh config/zookeeper.properties


### Start the Kafka broker service
Open another terminal session and run:
$ bin/kafka-server-start.sh config/server.properties 
Once all services have successfully launched, you will have a basic Kafka environment running and ready to use.

### Before start the projects
Open a terminal navigate to /spring-bootKafka-model and run:
$ mvn clean install

### run spring-boot-kafka-producer app
make a post request on:
    http://localhost:8080/api/v1/kafka/publish-json
    with body:

    {
        "id": 1,
        "name": "name",
        "description": "des",
        "category" : {
            "id": 1,
            "name": "name2"
        }
    }

### run spring-boot-kafka-cosumer app
see log data
 