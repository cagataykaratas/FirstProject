package com.example.firstP.Mapper;

import com.example.firstP.DTO.UserDTO;
import com.example.firstP.Entity.User;
import com.example.firstP.Repository.UserRepository;

public class UserMapper {

    UserRepository userRepository;



    public UserDTO mapToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setSurname((user.getSurname()));
        userDTO.setAge(user.getAge());
        userDTO.setSex(user.getSex());
        userDTO.setStudentNumber(user.getStudentNumber());
        userDTO.setDeleted(user.isDeleted());
        return userDTO;
    }

    public User mapToUser(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setAge(userDTO.getAge());
        user.setSex(userDTO.getSex());
        user.setStudentNumber(userDTO.getStudentNumber());
        user.setDeleted(userDTO.isDeleted());
        return user;
    }

}
