package com.blogwebapp.blogrepository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogwebapp.blogmodel.BlogModel;

public interface BlogRepository extends MongoRepository<BlogModel, String> {

    List<BlogModel> findAllByUserId(String id);

}
