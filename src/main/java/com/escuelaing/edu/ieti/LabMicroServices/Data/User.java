package com.escuelaing.edu.ieti.LabMicroServices.Data;

import com.escuelaing.edu.ieti.LabMicroServices.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Document
public class User {

    private static final AtomicInteger count= new AtomicInteger(1);
    @Id
    private int id;
    private String name;
    @Indexed( unique = true )
    private String email;
    private String lastName;
    private Date createdAt;

    public  User(UserDto userDto){
        id=count.getAndIncrement();
        this.name=userDto.getName();
        this.email=userDto.getEmail();
        this.lastName=userDto.getLastName();
        createdAt=new Date();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
