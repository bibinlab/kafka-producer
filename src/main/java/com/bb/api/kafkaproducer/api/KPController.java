package com.bb.api.kafkaproducer.api;

import com.bb.api.kafkaproducer.service.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KPController {

    private final KafkaProducer kafkaProducer;

    public KPController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/health")
    public ResponseEntity health(){
        return new ResponseEntity<String>("OK",  HttpStatus.OK);
    };

    @PostMapping("/send/{key}")
    public ResponseEntity send(@PathVariable int key, @RequestBody String event){
        kafkaProducer.send(event,key);
        return new ResponseEntity<String>("Event Published!",  HttpStatus.OK);
    }



}
