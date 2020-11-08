package net.crudapp.service;


import net.crudapp.model.Role;
import net.crudapp.model.User;
import net.crudapp.repository.RoleRepository;
import net.crudapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User getUserByName(String username) {
        return userRepository.getUserByEmail(username);
    }

    public List<User> allUsers() {
        return this.userRepository.findAll();
    }

    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    public void updateUser(User user) {
        this.userRepository.save(user);
    }

    public void deleteUser(long id) {
       this.userRepository.deleteById(id);
    }

//    public User getUserById(long id) {
//        return this.userRepository.getOne(id);
//    }


    public User getUserById(long id) {
        return this.userRepository.findById(id).get();
    }

    public List<Role> allRoles(){
        return this.roleRepository.findAll();
    }

}
