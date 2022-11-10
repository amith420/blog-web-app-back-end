package com.blogwebapp.blogcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogwebapp.blogmodel.User;
import com.blogwebapp.blogservice.UserServ;

@RestController
@RequestMapping("/user")
public class UserControl {
    @Autowired
    private UserServ userServ;

    @GetMapping("/all")
    public List<User>getAllUsers(){
        return userServ.findAll();
    }

    @GetMapping("/id/{id}")
    public User getUsersById(@PathVariable String id){
        return userServ.findById(id);
    }

    @PostMapping("/create")
    public User generate(@RequestBody User user){
        return userServ.create(user);
    }

    @PutMapping("/update")
    public User edit(@RequestBody User user){
        return userServ.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        userServ.delete(id);
    }

}
