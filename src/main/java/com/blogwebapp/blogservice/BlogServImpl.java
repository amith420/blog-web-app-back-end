package com.blogwebapp.blogservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogwebapp.blogmodel.BlogModel;
import com.blogwebapp.blogmodel.PreviousId;
import com.blogwebapp.blogrepository.BlogRepository;
import com.blogwebapp.blogrepository.PreviousIdRepository;

@Component
public class BlogServImpl implements BlogServ {

    @Autowired
    private PreviousIdRepository previousIdRepository;

    @Autowired
    private BlogRepository blogRepo;

    @Override
    public BlogModel create(BlogModel blog) {
        
        // get document contains previous id
        PreviousId previousIdModel = previousIdRepository.findByType("blog");

        Integer previousBlogId = previousIdModel.getPreviousId();

        // increment previous id and set as _id in UserModel
        if (previousBlogId < 9) {
            blog.setId("BN00" + ++previousBlogId);
        } else {
            blog.setId("BN0" + ++previousBlogId);
        }

        // save incremented previousId in PreviousUserModel
        previousIdModel.setPreviousId(previousBlogId);
        previousIdRepository.save(previousIdModel);

        blog.setCreatedAt(new Date());
        // blog.setDate(new Date());
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

    @Override
    public List<BlogModel> getBlogsByUser(String id) {
        return blogRepo.findAllByUserId(id);
    }

    @Override
    public BlogModel getLikes(String blogId, String userId) {
        BlogModel blog = blogRepo.findById(blogId).get();
        List<String> likes = blog.getLikes();
        likes.add(userId);
        blog.setLikes(likes);
        return blogRepo.save(blog);
    }

    @Override
    public BlogModel removeLikes(String blogId, String userId) {
        BlogModel blog = blogRepo.findById(blogId).get();
        List<String> likes = blog.getLikes();
        likes.remove(userId);
        blog.setLikes(likes);
        return blogRepo.save(blog);
    }
    
    
}
