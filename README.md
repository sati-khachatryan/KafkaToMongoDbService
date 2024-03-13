# Service that gets message from kafka and stores data in mongodb.

This is a Java project that demonstrates how to use Docker Compose to run Kafka and MongoDB. It includes instructions for running a Kafka console producer in a Docker container to send topics to Kafka.

## Requirements

- Docker
- Docker Compose

## Installation and Setup

1. Clone this repository:

    ```bash
    git clone <repository_url>
    cd <project_directory>
    ```

2. Run Docker Compose to start Kafka and MongoDB containers:

    ```bash
    docker-compose up -d
    ```

3. Verify that Kafka and MongoDB containers are running:

    ```bash
    docker-compose ps
    ```

## Sending Topics to Kafka

To send topics to Kafka, you can use the Kafka console producer. Follow the steps below:

1. Find the ID of the Kafka container:

    ```bash
    docker ps
    ```

2. Start a Docker container to run the Kafka console producer:

    ```bash
    docker exec -it <kafka_container_id> kafka-console-producer.sh --broker-list localhost:9092 --topic your_topic_name
    ```

   Replace `<kafka_container_id>` with the actual ID of the Kafka container and `your_topic_name` with the name of the Kafka topic you want to produce messages to.

3. Enter your messages in the console and press Enter to send them to the Kafka topic.

## Stopping and Cleaning Up

To stop and remove the Docker containers created by Docker Compose, run:

```bash
docker-compose down
