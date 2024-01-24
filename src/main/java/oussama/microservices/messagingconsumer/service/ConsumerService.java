package oussama.microservices.messagingconsumer.service;

import oussama.microservices.messagingconsumer.domain.User;
import oussama.microservices.messagingconsumer.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @Autowired
    public ConsumerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue2")
    public void receivedMessageFromQueue1(User user) {
        User save = userRepository.save(user);
        logger.info("Persisted " + save);
        logger.info("Received message from Queue 2: " + user);
    }


}
