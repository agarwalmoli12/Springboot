package com.firstproject.myfirstproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class cat {
    @Autowired
    dog Dog;


    public String name(){
        return Dog.name();
    }


}
