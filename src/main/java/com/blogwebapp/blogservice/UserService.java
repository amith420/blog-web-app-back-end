package com.blogwebapp.blogservice;

import java.util.List;

import com.blogwebapp.blogmodel.UserModel;

public interface UserService {

    UserModel create(UserModel user);

    List<UserModel> findAll();

    UserModel findById(String id);

    void delete(String id);

    UserModel update(UserModel user);

    UserModel checkEmailAndPassword(String email, String password);

}
