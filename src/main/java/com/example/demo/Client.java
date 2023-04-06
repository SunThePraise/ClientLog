package com.example.demo;
import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;

import java.util.*;

@Entity
public class Client {
    @Id
    private String name;
    private int age;

    private String status;

    public Client(){}

    public Client(String name, int age, String status){
        this.name = name;
        this.age = age;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return "Client: " + this.name + "age: " + this.age + "status is: " + this.status;
    }
}
