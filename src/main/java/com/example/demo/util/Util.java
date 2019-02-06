package com.example.demo.util;

import com.example.demo.entity.InformationEntity;
import com.example.demo.model.Information;

import java.util.ArrayList;
import java.util.List;

public class Util {
    // Transfer data between entities and data objects.

    public static List<InformationEntity> toEntity(List<Information> data){
        List<InformationEntity> result = new ArrayList<>();

        for (Information inf : data){
            // Checks?
            InformationEntity temp = new InformationEntity();
            temp.setData(inf.getData());
            result.add(temp);
        }

        return result;
    }

    public static List<Information> toModel(List<InformationEntity> data){
        List<Information> result = new ArrayList<>();

        for (InformationEntity inf : data){
            // Checks?
            Information temp = new Information();
            temp.setData(inf.getData());
            result.add(temp);
        }

        return result;
    }

}
