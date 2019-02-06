package com.example.demo.util;

import com.example.demo.entity.InformationEntity;
import com.example.demo.model.Information;

import java.util.ArrayList;
import java.util.List;

public class Util {
    // Transfer data between entities and data objects.

    public static List<InformationEntity> toInformationEntityList(List<Information> data){
        List<InformationEntity> result = new ArrayList<>();

        for (Information inf : data){
            InformationEntity temp = new InformationEntity();
            temp.setData(inf.getData());
            result.add(temp);
        }

        return result;
    }

    public static List<Information> toInformationList(List<InformationEntity> data){
        List<Information> result = new ArrayList<>();

        for (InformationEntity inf : data){
            Information temp = new Information();
            temp.setData(inf.getData());
            result.add(temp);
        }

        return result;
    }

}
