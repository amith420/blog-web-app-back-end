package com.blogwebapp.blogcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogwebapp.blogmodel.BlogModel;
import com.blogwebapp.blogservice.BlogServ;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogServ blogServ;

    @GetMapping("/all")
    public List<BlogModel> getAllBlogs() {
        return blogServ.findAll();
    }

    @GetMapping("/id/{id}")
    public BlogModel getBlogsById(@PathVariable String id) {
        return blogServ.findById(id);
    }

    @GetMapping("/user/{id}")
    public List<BlogModel> getBlogsByUser(@PathVariable String id) {
        return blogServ.getBlogsByUser(id);
    }

    @PatchMapping("/like/{blogId}/{userId}")
    public BlogModel getLikes(@PathVariable("blogId") String blogId, @PathVariable("userId") String userId) {
        return blogServ.getLikes(blogId, userId);
    }

    @PatchMapping("/remove/{blogId}/{userId}")
    public BlogModel removeLikes(@PathVariable("blogId") String blogId, @PathVariable("userId") String userId) {
        return blogServ.removeLikes(blogId, userId);
    }

    @PostMapping("/create")
    public BlogModel create(@RequestBody BlogModel blog) {
        return blogServ.create(blog);
    }

    @PutMapping("/update")
    public BlogModel update(@RequestBody BlogModel blog) {
        return blogServ.update(blog);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        blogServ.delete(id);
    }
}
