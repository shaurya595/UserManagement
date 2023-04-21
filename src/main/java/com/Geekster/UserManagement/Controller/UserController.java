package com.Geekster.UserManagement.Controller;

import com.Geekster.UserManagement.Service.Models.User;
import com.Geekster.UserManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    // get all userList
    @GetMapping(value = "/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @PostMapping (value = "/addUser")
    public String addUser(@RequestBody User user ){
      return userService.addMyUser(user);
    }
    @RequestMapping(value = "/getById/{id}" , method = RequestMethod.GET)
    public User getUserById(@PathVariable String id){
        return userService.getUserBasedOnId(id);
    }
    //delete User
    @DeleteMapping(value="/deleteUser/{id}")
    public String DeleteUserById(@PathVariable String id){
        return userService.removeUserById(id);
    }

    @PutMapping(value = "/update/{id}")
    public String updateUserById(@PathVariable String id, @PathVariable String status){
        return userService.updateById(id , status);
    }


}
