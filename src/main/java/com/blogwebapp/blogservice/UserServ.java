package com.blogwebapp.blogservice;

import java.util.List;

import com.blogwebapp.blogmodel.User;

public interface UserServ {
    User create (User user);

    List<User>findAll();

    User findById(String id);

    void delete(String id);

    User update(User user);
}
