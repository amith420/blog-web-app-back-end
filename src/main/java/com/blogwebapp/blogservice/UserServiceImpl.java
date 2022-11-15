package com.blogwebapp.blogservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.blogwebapp.blogmodel.UserModel;
import com.blogwebapp.blogrepository.UserRepository;


@Component
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepo;

    @Override
    public UserModel create(UserModel user) {
        return userRepo.save(user);
    }

    @Override
    public List<UserModel> findAll() {
        return userRepo.findAll();
    }

    @Override
    public UserModel findById(String id) {
        return userRepo.findById(id).get();
    }

    @Override
    public void delete(String id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserModel update(UserModel user) {
        return userRepo.save(user);
    }

    @Override
    public Boolean checkEmailAndPassword(String email, String password) {
        return userRepo.existsByEmailAndPassword( email, password) ;
    }
    
}
