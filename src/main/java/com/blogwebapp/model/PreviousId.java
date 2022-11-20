package com.blogwebapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "previousId")

public class PreviousId {
    @Id
    private String id;
    private String type;
    private Integer previousId;
}
