package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.User;
import com.S2t.ConsommiTounsi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public Map<String, Boolean> deleteUser(long id){
        userRepository.deleteById(id);
        Map<String, Boolean> res = new HashMap<>();
        res.put("deleted", Boolean.TRUE);
        return res;
    }

    @Override
    public User updateUser(long id, User user) {
        User old = getUser(id);
        old.setUsername(user.getUsername());
        old.setPassword(user.getPassword());
        old.setEmail(user.getEmail());

        return userRepository.save(old);
    }

    @Override
    public List<User> serachByusername(String username) {
        return userRepository.findByusername(username);
    }

    @Override
    public List<User> serachByemail(String email) {
        return userRepository.findByemail(email);
    }
}

