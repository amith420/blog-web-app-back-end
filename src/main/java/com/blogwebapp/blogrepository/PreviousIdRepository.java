package com.blogwebapp.blogrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogwebapp.blogmodel.PreviousId;

public interface PreviousIdRepository extends MongoRepository<PreviousId, String> {

    PreviousId findByType(String type);

    PreviousId save(PreviousId previousIdModel);

}