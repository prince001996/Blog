package com.prince.blog.service;


import com.prince.blog.entity.Users;
import com.prince.blog.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;


    public List<Users> getAllUsers(){
        List<Users> usersInfo = usersRepository.findAll();
        return usersInfo;
    }

    public Users addUser(Users user){
        Users user1 = usersRepository.save(user);
        return user1;
    }

    public String updateUser(Users user) {
        //fetch the user
        Optional<Users> user1 = usersRepository.findById(user.getEmail());

        if(user1.isPresent()){
            user1.get().setName(user.getName());
            user1.get().setMobile(user.getMobile());
            user1.get().setEmail(user.getEmail());
            user1.get().setPassword(user.getPassword());

            usersRepository.save(user1.get());

            return "Info Updated";
        }

        return "Repository Error";
    }


    public String deleteUser(String email) {
        //fetch the user
        Users user = usersRepository.findById(email).get();
        try{
            usersRepository.delete(user);
            return "Successfully Deleted";
        }
        catch(Exception e){
            return "Delete Failed";
        }
    }
}
