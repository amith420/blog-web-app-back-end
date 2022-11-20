package com.blogwebapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blogwebapp.model.BlogModel;
import com.blogwebapp.model.PreviousId;
import com.blogwebapp.repository.BlogRepository;
import com.blogwebapp.repository.PreviousIdRepository;

@Component
public class BlogServiceImpl implements BlogService {

    @Autowired
    private PreviousIdRepository previousIdRepository;

    @Autowired
    private BlogRepository blogRepo;

    @Override
    public BlogModel create(BlogModel blog) {
        PreviousId previousIdModel = previousIdRepository.findByType("blog");
        Integer previousBlogId = previousIdModel.getPreviousId();

        if (previousBlogId < 9) {
            blog.setId("BN00" + ++previousBlogId);
        } else {
            blog.setId("BN0" + ++previousBlogId);
        }

        previousIdModel.setPreviousId(previousBlogId);
        previousIdRepository.save(previousIdModel);

        blog.setCreatedAt(new Date());
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
        BlogModel blogDb = blogRepo.findById(blog.getId()).get();
        blogDb.setBlogTitle(blog.getBlogTitle());
        blogDb.setBlogContent(blog.getBlogContent());
        blogDb.setLikes(blog.getLikes());
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
