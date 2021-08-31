package com.example.firstP.Service;

import com.example.firstP.DTO.UserDTO;
import com.example.firstP.Entity.User;
import com.example.firstP.Mapper.UserMapper;
import com.example.firstP.Repository.UserRepository;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){

        this.userRepository = userRepository;
    }

    User user1 = new User();
    public UserDTO save(User user) {
        UserMapper userMapper = new UserMapper();
        userRepository.save(user);
        return userMapper.mapToDTO(user);
    }

   public User update(User user, int studentNumber){
       User user1 = userRepository.findByStudentNumber(studentNumber);
       user1.setName(user.getName());
       user1.setSurname(user.getSurname());
       user1.setAge(user.getAge());
       user1.setSex(user.getSex());
       user1.setStudentNumber(user.getStudentNumber());
       user1.setDeleted(user.isDeleted());
       return userRepository.save(user1);
    }

    public User delete(int number) {
        User user1 = userRepository.findByStudentNumber(number);
        if(!user1.isDeleted()){
            user1.setDeleted(true);
        }
        return userRepository.save(user1);
    }

    public User getUser(int number) {
        user1 = userRepository.findByStudentNumber(number);
        return user1;
    }
}
