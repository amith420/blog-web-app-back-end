package com.blogwebapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blogwebapp.model.UserModel;

@Repository

public interface UserRepository extends MongoRepository<UserModel, String> {

    boolean existsByEmail(String email);

    List<UserModel> findAll();

    Optional<UserModel> findById(String id);

    void deleteById(String id);

    UserModel save(UserModel user);

    UserModel findByEmailAndPassword(String email, String password);

}
