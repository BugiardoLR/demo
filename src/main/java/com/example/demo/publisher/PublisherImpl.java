package com.example.demo.publisher;


import com.example.demo.model.Information;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublisherImpl implements Publisher {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topicName;

    @Value("${list.split.step}")
    private int splitStep;

    @Autowired
    private Gson gson;


    @Override
    public void publish(List<Information> data) {
        ArrayList<String> messages = new ArrayList<>();

        if (data.size() > splitStep){
            for (int i = 0; i < data.size() - splitStep ; i+= splitStep){
                String msg = gson.toJson(data.subList(i , i + splitStep));
                messages.add(msg);
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
