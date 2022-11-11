package com.blogwebapp.blogservice;

import java.util.List;

import com.blogwebapp.blogmodel.BlogModel;

public interface BlogServ {

    BlogModel create(BlogModel blog);

    List<BlogModel>findAll();

    BlogModel findById(String id);

    void delete(String id);

    BlogModel update(BlogModel blog);
}
