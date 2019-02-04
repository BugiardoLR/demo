package com.example.demo.controllers;

import com.example.demo.model.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recieve")
public class RecieverController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;


    @PostMapping
    public void recieveDummyInput(@RequestBody List<Information> data){
        //STORE IT IN KAFKA Non blocking, Thread?
        String msg = ""; // Data to json
        kafkaTemplate.send(topicName, msg);
    }

    @GetMapping
    public List<Information> test(){
        List<Information> data = new ArrayList<>();
        for (int i =0 ; i < 5; i++){
            Information inf = new Information();
            inf.setData("Hello");
            data.add(inf);
        }
        return data;
    }
}
