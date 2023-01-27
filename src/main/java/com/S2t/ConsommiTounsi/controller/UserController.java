package com.S2t.ConsommiTounsi.controller;
import com.S2t.ConsommiTounsi.entities.User;
import com.S2t.ConsommiTounsi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/users")
public class UserController extends BasicController{
    @Autowired
    UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user){

        return userService.save(user);
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping(value = "/{id}")

    public User getUser(@PathVariable("id")long id)  {
        return userService.getUser(id);
    }

    @DeleteMapping
    public Map<String,Boolean> deleteUser(@RequestParam("id") long id){
        return userService.deleteUser(id);
    }


    @PutMapping
    public User updateUser(@RequestParam("id") long id, @RequestBody User user){
        return  userService.updateUser(id, user);
    }
    @GetMapping(value = "/find")
    public  List<User> getByusername(@RequestParam("username") String username){
        return userService.serachByusername(username);
    }
    @GetMapping(value = "/search")
    public  List<User> getByemail(@RequestParam("email") String email){
        return userService.serachByemail(email);
    }
}

