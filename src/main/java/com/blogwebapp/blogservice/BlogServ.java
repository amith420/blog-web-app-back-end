package com.blogwebapp.blogservice;

import java.util.List;

import com.blogwebapp.blogmodel.Blog;

public interface BlogServ {

    Blog create(Blog blog);

    

    List<Blog>findAll();

    Blog findById(String id);

    void delete(String id);

    Blog update(Blog blog);
}
