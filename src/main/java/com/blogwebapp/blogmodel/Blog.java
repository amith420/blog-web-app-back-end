package com.blogwebapp.blogmodel;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Blog")

public class Blog {
    @Id
    private String blogId;
    private String title;
    private String content;
    private Date date;
    private Integer like;  
}
