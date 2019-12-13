package com.tw.sg.dataguild;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import com.google.gson.*;
import org.apache.kafka.clients.producer.*;

import javax.net.ssl.HttpsURLConnection;

public class CitybikeApiProducer {
    public static void main(String[] args) throws Exception{
        Properties props = new Properties();
        props.put("bootstrap.servers","localhost:9092");
        props.put("acks","all");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer(props);


        String httpsURL = "https://api.citybik.es/v2/networks/citi-bike-nyc";
        URL myUrl = new URL(httpsURL);
        HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(3000);

        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String inputLine;
        JsonObject network;
        while ((inputLine = br.readLine()) != null) {
            network = new JsonParser()
                    .parse(inputLine)
                    .getAsJsonObject()
                    .getAsJsonObject("network");

            System.out.println(network);
            producer.send(new ProducerRecord<String, String>("test", "", network.toString()));
        }

        br.close();
        conn.disconnect();
        producer.close();
    }
}
