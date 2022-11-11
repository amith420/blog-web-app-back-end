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
    private String title;
    private String content;
    private Date date;
    private Integer like;  
}
