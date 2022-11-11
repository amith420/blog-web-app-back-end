package com.blogwebapp.blogrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogwebapp.blogmodel.BlogModel;

public interface BlogRepository extends MongoRepository<BlogModel, String> {
    
    
}
