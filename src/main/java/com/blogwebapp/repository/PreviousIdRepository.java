package com.blogwebapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogwebapp.model.PreviousId;

public interface PreviousIdRepository extends MongoRepository<PreviousId, String> {

    PreviousId findByType(String type);

    PreviousId save(PreviousId previousIdModel);

}