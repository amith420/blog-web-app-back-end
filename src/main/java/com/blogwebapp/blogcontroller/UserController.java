package com.blogwebapp.blogcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogwebapp.blogmodel.UserModel;
import com.blogwebapp.blogservice.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userServ;

    @GetMapping("/all")
    public List<UserModel>getAllUsers(){
        return userServ.findAll();
    }

    @GetMapping("/id/{id}")
    public UserModel getUsersById(@PathVariable String id){
        return userServ.findById(id);
    }

    @PostMapping("/create")
    public UserModel create(@RequestBody UserModel user){
        return userServ.create(user);
    }

    @PostMapping("/login")
    public Boolean logincheck(@RequestBody UserModel user){
        return userServ.checkEmailAndPassword(user.getEmail(),user.getPassword());
    }

    @PutMapping("/update")
    public UserModel update(@RequestBody UserModel user){
        return userServ.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        userServ.delete(id);
    }

}
