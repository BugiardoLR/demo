package com.example.demo.publisher;


import com.example.demo.model.Information;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublisherImpl implements Publisher<List<Information>> {

    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson;

    @Value("${kafka.topic.name}")
    private String topicName;

    @Value("${list.split.step}")
    private int splitStep;

    public PublisherImpl(KafkaTemplate<String, String> kafkaTemplate, Gson gson) {
        this.kafkaTemplate= kafkaTemplate;
        this.gson = gson;
    }

    @Override
    public void publish(List<Information> data) {
        ArrayList<String> messages = new ArrayList<>();

        if (data.size() > splitStep){
            for (int i = 0; i < data.size() - splitStep ; i+= splitStep){
                String sublistJson = gson.toJson(data.subList(i , i + splitStep));
                messages.add(sublistJson);
            }
        }else{
            String msg = gson.toJson(data);
            messages.add(msg);
        }

        for (String msg : messages){
            kafkaTemplate.send(topicName,msg);
        }

    }
}
