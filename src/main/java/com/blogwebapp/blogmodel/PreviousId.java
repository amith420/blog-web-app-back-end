package com.blogwebapp.blogmodel;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "previousId")

public class PreviousId {
    private String type;
    private Integer previousId;
}
