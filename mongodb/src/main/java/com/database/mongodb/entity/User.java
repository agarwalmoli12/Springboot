package com.database.mongodb.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;


@Document(collection="users")
@Data
public class User {

    @Id
    private String id;
    @Indexed(unique=true)
    @NonNull
    private String username;
    @NonNull
    private String password;

    @DBRef  
    List<Course> course=new ArrayList<>();
    

    
    }

