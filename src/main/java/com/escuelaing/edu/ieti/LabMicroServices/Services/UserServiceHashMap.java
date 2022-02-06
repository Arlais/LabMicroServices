package com.escuelaing.edu.ieti.LabMicroServices.Services;

import com.escuelaing.edu.ieti.LabMicroServices.Data.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserServiceHashMap implements UserService {

    private HashMap<Integer,User> Users = new HashMap();

    @Override
    public User create(User user) {
        Users.put(user.getId(),user);
        return user;
    }

    @Override
    public User findById(int id) {
        return Users.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList(Users.values());
    }

    @Override
    public void deleteById(int id) throws Exception {
        if (Users.containsKey(id)){
            Users.remove(id);
        }
        else{
            throw new Exception("Not Found");
        }
    }

    @Override
    public User update(User user, int userId) {
        user.setId(userId);
        Users.put(userId, user);
        return Users.get(userId);
    }
}
