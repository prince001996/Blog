package com.prince.blog.controller;

import com.prince.blog.entity.Users;
import com.prince.blog.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1")
@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    public List<Users> getAllUsers(){
        List<Users> usersInfo = usersService.getAllUsers();
        return usersInfo;
    }

    @PostMapping("/user")
    public Users addUser(@RequestBody Users user){
        Users user1 = usersService.addUser(user);
        return user1;
    }

    @PutMapping("/user")
    public String updateUser(@RequestBody Users user){
        String msg = usersService.updateUser(user);
        return msg;
    }

    @DeleteMapping("/user/{email}")
    public String deleteUser(@PathVariable("email") String email){
        String msg = usersService.deleteUser(email);
        return msg;
    }




}
