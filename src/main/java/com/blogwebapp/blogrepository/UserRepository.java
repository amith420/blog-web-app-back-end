package com.blogwebapp.blogrepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blogwebapp.blogmodel.UserModel;

public interface UserRepository extends MongoRepository<UserModel,String> {

    boolean existsByEmail(String email);

    UserModel findByEmailAndPassword(String email, String password);
    
}
