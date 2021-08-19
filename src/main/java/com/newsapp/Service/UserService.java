package com.newsapp.Service;

import com.newsapp.Model.DAO.User;
import com.newsapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        if ( userRepository.existsByEmail(email)) {
            System.out.println("A mers.");
            return userRepository.findByEmail(email);
        } else {
            System.out.println("Nu a mers");
            return null;
        }
    }


    public String updateUser(User user, int id) {
        User oldUser = userRepository.findById(id).get();

        oldUser.setFirstname(user.getFirstname());
        oldUser.setLastname(user.getLastname());
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        oldUser.setCity(user.getCity());
        oldUser.setPassword(user.getPassword());
        oldUser.setGender(user.getGender());

        this.userRepository.save(oldUser);
        return "User updated successfully";
    }


    public String deleteUser( int id) {
        userRepository.deleteById(id);
        return "User deleted successfully";

    }

}
