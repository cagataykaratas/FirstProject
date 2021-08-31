package com.example.firstP.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String surname;
    private int age;
    private String sex;
    private int studentNumber;
    private boolean deleted = false;

}

