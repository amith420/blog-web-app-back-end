package com.blogwebapp.blogrepository;



import org.springframework.data.mongodb.repository.MongoRepository;


import com.blogwebapp.blogmodel.Blog;


public interface BlogRepo extends MongoRepository<Blog, String> {
    
    
}
