package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class InformationEntity extends BaseEntity {

    @Column(name= "data")
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
