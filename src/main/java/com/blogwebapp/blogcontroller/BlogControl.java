package com.blogwebapp.blogcontroller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogwebapp.blogmodel.Blog;
import com.blogwebapp.blogservice.BlogServ;

@RestController

public class BlogControl {
    @Autowired
    private BlogServ blogServ;

    @GetMapping("/all")
    public List<Blog>getAllBlogs(){
        return blogServ.findAll();   
    }

    
    @GetMapping("/id/{id}")
    public Blog getBlogsById(@PathVariable String id){
        return blogServ.findById(id);   
    }

    @PostMapping("/create")
    public Blog create(@RequestBody Blog blog){
        return blogServ.create(blog);
    }

    @PutMapping("/update")
    public Blog update(@RequestBody Blog blog){
        return blogServ.update(blog);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        blogServ.delete(id);
    }
}
