package net.crudapp.controller;

import net.crudapp.model.User;
import net.crudapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminRestController {

    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/userList")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(this.userService.allUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/userList/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/userList/save")
    public ResponseEntity<Void> saveOrUpdateUser(@RequestBody User user){
        this.userService.saveUser(user);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping(value = "/userList/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id){
        this.userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
