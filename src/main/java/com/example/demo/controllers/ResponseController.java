package com.example.demo.controllers;

import com.example.demo.entity.InformationEntity;
import com.example.demo.model.Information;
import com.example.demo.repository.DataRepository;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/data")
public class ResponseController {

    DataRepository dataRepository;

    @Autowired
    public ResponseController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @GetMapping
    public List<Information> getDBContent(){
        ArrayList<InformationEntity> result = dataRepository.findAll();
        List<Information> infList = Util.toInformationList(result);
        return infList;
    }
}
