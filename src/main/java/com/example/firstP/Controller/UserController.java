package com.example.firstP.Controller;

import com.example.firstP.DTO.UserDTO;
import com.example.firstP.Entity.User;
import com.example.firstP.Mapper.UserMapper;
import com.example.firstP.Repository.UserRepository;
import com.example.firstP.Service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private User List;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/save-user")
    public UserDTO save(@RequestBody UserDTO userDTO){
        UserMapper userMapper = new UserMapper();
        return userService.save(userMapper.mapToUser(userDTO));
    }

    @PutMapping("/update-user/{studentNumber}")
    public User update(@PathVariable("studentNumber") int studentNumber, @RequestBody User user){
        return userService.update(user, studentNumber);
    }

    @PostMapping("/delete-user/{studentNumber}")
    public User delete(@PathVariable("studentNumber") int studentNumber){
        return userService.delete(studentNumber);
    }

    @GetMapping("/get-all-users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/get-user/{studentNumber}")
    public User getUser(@PathVariable("studentNumber") int studentNumber){
        return userService.getUser(studentNumber);
    }
}
