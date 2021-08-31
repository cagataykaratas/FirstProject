package com.example.firstP.Entity;


import lombok.Data;

import javax.persistence.*;
@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    private int age;
    private String sex;

    @Column(unique=true)
    private int studentNumber;
    private boolean deleted = false;

    public User() {

    }

    public User(String name, String surname, int age, String sex, int studentNumber, boolean deleted){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.studentNumber = studentNumber;
        this.deleted = deleted;
    }

}




