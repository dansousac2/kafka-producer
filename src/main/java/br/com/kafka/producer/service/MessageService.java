package br.com.kafka.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Value("${topic.bora-praticar}")
    private String topicBoraPraticar;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    // lógica de envio de mensagem
    public void sendMessage(String message) {
        logger.info("Sended message -> {}", message);
        this.kafkaTemplate.send(topicBoraPraticar, message);
    }
}