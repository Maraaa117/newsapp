package com.newsapp.Controller;

import com.newsapp.Model.DAO.User;
import com.newsapp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
    public String updateUsers(@RequestBody User user, @PathVariable int id) {
        return userService.updateUser(user,id);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

}
