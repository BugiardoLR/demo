package com.example.demo.repository;

import com.example.demo.entity.InformationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DataRepository extends CrudRepository<InformationEntity, Long> {
    //TODO Add transactional save

    @Override
    ArrayList<InformationEntity> findAll();
}
