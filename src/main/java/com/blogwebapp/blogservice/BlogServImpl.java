package com.blogwebapp.blogservice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogwebapp.blogmodel.Blog;
import com.blogwebapp.blogrepository.BlogRepo;
@Service

public class BlogServImpl implements BlogServ {

    @Autowired
    private BlogRepo blogRepo;

    @Override
    public Blog create(Blog blog) {
        blog.setDate(new Date());
        blog.setLike(0);
        return blogRepo.save(blog);
    }

   
    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public void delete(String id) {
        blogRepo.deleteById(id);
    }

    @Override
    public Blog update(Blog blog) {
        return blogRepo.save(blog);
    }

    @Override
    public Blog findById(String id) {
        return blogRepo.findById(id).get();
    }
    
    
}
