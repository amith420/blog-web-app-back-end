package com.blogwebapp.blogmodel;

import java.util.Date;

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
    private Date date;
    private Integer like;  
}
