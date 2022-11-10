package com.blogwebapp.blogrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogwebapp.blogmodel.User;

public interface UserRepo extends MongoRepository<User,String> {
    
}
