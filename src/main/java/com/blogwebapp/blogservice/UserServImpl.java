package com.blogwebapp.blogservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.blogwebapp.blogmodel.User;
import com.blogwebapp.blogrepository.UserRepo;


@Component
public class UserServImpl implements UserServ{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(String id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void delete(String id) {
        userRepo.deleteById(id);
    }

    @Override
    public User update(User user) {
        return userRepo.save(user);
    }
    
}
