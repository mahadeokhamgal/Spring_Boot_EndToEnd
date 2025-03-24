package com.mahadeo.demo.Entity;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "user")
@Getter
@Setter
public class User {
    
    @Id //uniq key
    private ObjectId id;
    private String name;
    private String email;
    private LocalDate date;

    public User(ObjectId id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}