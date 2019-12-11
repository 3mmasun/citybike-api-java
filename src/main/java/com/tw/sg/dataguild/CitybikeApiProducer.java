package com.tw.sg.dataguild;

import java.util.Properties;
import org.apache.kafka.clients.producer.*;

public class CitybikeApiProducer {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","localhost:9092");
        props.put("acks","all");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer(props);
        producer.send(new ProducerRecord<String, String>("test", "", "Hello there"));
        producer.close();
    }
}
