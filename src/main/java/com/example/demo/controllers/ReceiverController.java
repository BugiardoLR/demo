package com.example.demo.controllers;

import com.example.demo.model.Information;
import com.example.demo.publisher.Publisher;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receive")
public class ReceiverController {

    private Publisher publisher;

    public ReceiverController(Publisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping
    public void receiveDummyInput(@RequestBody List<Information> data){
        publisher.publish(data);
    }

}
