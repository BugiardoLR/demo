package com.example.demo.controllers;

import com.example.demo.entity.InformationEntity;
import com.example.demo.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/data")
public class ResponseController {

    @Autowired
    DataRepository dataRepository;

    @GetMapping
    public List<InformationEntity> getDBContent(){

        ArrayList<InformationEntity> result = dataRepository.findAll();

        return result;
    }
}
