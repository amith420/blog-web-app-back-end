package com.blogwebapp.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "blog")

public class BlogModel {
    @Id
    private String id;
    private String blogTitle;
    private String blogContent;
    private String author;
    private List<String> likes = new ArrayList<String>();
    private Date createdAt;
    private String userId;
}
