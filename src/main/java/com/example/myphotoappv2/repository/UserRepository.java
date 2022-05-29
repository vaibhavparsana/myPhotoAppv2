package com.example.myphotoappv2.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.myphotoappv2.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    List<User> userList= new ArrayList();

    public User getUser() {
        User user = new User("Adam", "White House", 21, "adam.png" );
        return user;
    }

    public User saveUser(User user) {
        user.setUserId(userList.size() + 1);
        userList.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userList;
    }

    public User getUserById(int userId) {
        for(User user:userList) {
            if(user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    public User updateUser(int userId, User user) {
        for(User u:userList) {
            if(u.getUserId() == userId) {
                u.setName(user.getName());
                u.setProfilePicUrl(user.getProfilePicUrl());
                u.setAge(user.getAge());
                u.setAddress(user.getAddress());
            
                return u;
            }
        }
        return null;
    }

    public User deleteUser(int userId) {
        User deletedUser = null;
        for(User user:userList) {
            if(user.getUserId() == userId) {
                deletedUser = user;
                userList.remove(user);
                return deletedUser;
            }
        }
        return deletedUser;
    }
    
}
