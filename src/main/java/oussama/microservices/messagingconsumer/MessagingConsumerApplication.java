package oussama.microservices.messagingconsumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class MessagingConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingConsumerApplication.class, args);
		System.out.println("Running...");
	}

}
