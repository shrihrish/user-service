package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;


//
//    public UserRepository getUserRepository() {
//        return userRepository;
//    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
       User savedUser =userRepository.save(user);
       return  savedUser;
    }


    public User updateUser(User user){
    User updateUser = userRepository.save(user);
    return updateUser;
    }

    public List<User> getAllUser(){
    return (List<User>) userRepository.findAll();
    }

    public  User getUserById(int id){
    return userRepository.getOne(id);
    }

}

