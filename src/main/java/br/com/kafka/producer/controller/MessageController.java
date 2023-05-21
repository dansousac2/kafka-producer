package br.com.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kafka.producer.service.MessageService;

@RestController
@RequestMapping("api/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping
    public ResponseEntity<String> enviarMensagem(@RequestBody String message){
        try {
        	messageService.sendMessage(message);
        	return ResponseEntity.ok().body("Mensagem enviada com sucesso: " + message);

        } catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    }
}