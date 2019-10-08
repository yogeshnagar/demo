package com.yogesh.kafkaclient;

import java.util.Properties;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerMain {

	public static void main(String[] args) {
		
		String bootstrapServer = "localhost:9092";
		
		Properties properties = new Properties();
		
		properties.setProperty("bootstrap.servers", bootstrapServer);
		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", StringSerializer.class.getName());
		
		KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
		
		ProducerRecord<String, String> record = new  ProducerRecord<String, String>("java_topic", "Hello Java!");
		
		for (int i = 0; i < 10; i ++) {
			producer.send(record, new Callback() {
				
				public void onCompletion(RecordMetadata metadata, Exception exception) {
					
					if (exception == null) {
						System.out.println("Partition = " + metadata.partition() + " Offset = " + metadata.offset());
					}
					
				}
			});
		}
		
		
		
		producer.flush();
		
		producer.close();
		
		

	}

}
