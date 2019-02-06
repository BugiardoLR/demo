package com.example.demo.controllers;

import com.example.demo.model.Information;
import com.example.demo.publisher.Publisher;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recieve")
public class RecieverController {

    private Publisher publisher;

    public RecieverController(Publisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping
    public void recieveDummyInput(@RequestBody List<Information> data){
        publisher.publish(data);

    }

}
