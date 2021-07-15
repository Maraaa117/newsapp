package com.newsapp.Service;

import com.newsapp.Model.DAO.User;
import com.newsapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String saveUser(User user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            userRepository.save(user);
            return "User added successfully";
        } else {
            return "This user already exists in the database";
        }
    }

    public String showUser(User user) {
        return "";
    }
    public String updateUser(User user) {
        return "";
    }
    public String deleteUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            userRepository.delete(user);
            return "User deleted successfully";
        } else {
            return "User does not exist.";
        }
    }

}
