package com.blogwebapp.blogmodel;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "user")

public class UserModel {
    @Id
    private String id;
    private String name;
    private String email;
    private String role;
    private String dateofbirth;
    private String password;
    private Date createdAt;
}
