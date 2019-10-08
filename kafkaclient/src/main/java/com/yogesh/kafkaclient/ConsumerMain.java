package com.yogesh.kafkaclient;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class ConsumerMain {

	public static void main(String[] args) {
		
String bootstrapServer = "localhost:9092";
		
		Properties properties = new Properties();
		
		properties.setProperty("bootstrap.servers", bootstrapServer);
		properties.setProperty("key.deserializer", StringDeserializer.class.getName());
		properties.setProperty("value.deserializer", StringDeserializer.class.getName());
		
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "my-app");
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		
		consumer.subscribe(Collections.singleton("java_topic"));
		
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
			
			for (ConsumerRecord<String, String> record: records) {
				System.out.println(record.value());
			}
		}
		

	}

}
