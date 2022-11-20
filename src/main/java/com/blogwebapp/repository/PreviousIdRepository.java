package com.blogwebapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blogwebapp.model.PreviousId;

@Repository

public interface PreviousIdRepository extends MongoRepository<PreviousId, String> {

    PreviousId findByType(String type);

    PreviousId save(PreviousId previousIdModel);

}