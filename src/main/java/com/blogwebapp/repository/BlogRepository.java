package com.blogwebapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.blogwebapp.model.BlogModel;

@Repository

public interface BlogRepository extends MongoRepository<BlogModel, String> {

    List<BlogModel> findAllByUserId(String id);

    void deleteById(String id);

    BlogModel save(BlogModel blog);

    List<BlogModel> findAll();

    Optional<BlogModel> findById(String id);

}
