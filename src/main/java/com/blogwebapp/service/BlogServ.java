package com.blogwebapp.service;

import java.util.List;

import com.blogwebapp.model.BlogModel;

public interface BlogServ {

    BlogModel create(BlogModel blog);

    List<BlogModel> findAll();

    List<BlogModel> getBlogsByUser(String id);

    BlogModel findById(String id);

    void delete(String id);

    BlogModel update(BlogModel blog);

    BlogModel getLikes(String blogId, String userId);

    BlogModel removeLikes(String blogId, String userId);
}
