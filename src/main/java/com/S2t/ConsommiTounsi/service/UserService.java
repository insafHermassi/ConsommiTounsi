package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.entities.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public User save(User user);

    public User getUser(long id);

    public List<User> getUser();


    public Map<String, Boolean> deleteUser(long id);

    public User updateUser(long id, User user);

    public List<User> serachByusername(String username);

    public List<User> serachByemail(String email);
}
