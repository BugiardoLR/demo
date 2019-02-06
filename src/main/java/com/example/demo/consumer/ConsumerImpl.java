package com.example.demo.consumer;

import com.example.demo.entity.InformationEntity;
import com.example.demo.model.Information;
import com.example.demo.repository.DataRepository;
import com.example.demo.util.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class ConsumerImpl implements Consumer {

    DataRepository dataRepository;

    private Gson gson;

    @Autowired
    public ConsumerImpl(Gson gson, DataRepository dataRepository) {
        this.dataRepository = dataRepository;
        this.gson = gson;
    }

    @Override
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group.id}")
    public void consume(String msg) {

        List<InformationEntity> entityList = processJson(msg);
        dataRepository.saveAll(entityList);
        System.out.println(msg);
    }

    private List<InformationEntity> processJson(String json){
        Type type = new TypeToken<List<Information>>(){}.getType();
        List<Information> inpList = gson.fromJson(json, type);
        List<InformationEntity> entityList = Util.toInformationEntityList(inpList);
        return entityList;
    }
}
