package com.blogwebapp.blogservice;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogwebapp.blogmodel.BlogModel;
import com.blogwebapp.blogrepository.BlogRepository;

@Component
public class BlogServImpl implements BlogServ {

    @Autowired
    private BlogRepository blogRepo;

    @Override
    public BlogModel create(BlogModel blog) {
        blog.setDate(new Date());
        blog.setLike(0);
        return blogRepo.save(blog);
    }

   
    @Override
    public List<BlogModel> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public void delete(String id) {
        blogRepo.deleteById(id);
    }

    @Override
    public BlogModel update(BlogModel blog) {
        return blogRepo.save(blog);
    }

    @Override
    public BlogModel findById(String id) {
        return blogRepo.findById(id).get();
    }
    
    
}
