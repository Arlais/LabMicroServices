package com.escuelaing.edu.ieti.LabMicroServices.Services;

import com.escuelaing.edu.ieti.LabMicroServices.Data.User;
import com.escuelaing.edu.ieti.LabMicroServices.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB implements UserService{

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User create( User user )
    {
        return userRepository.insert(user);
    }

    @Override
    public User findById( int id ) throws Exception {
        Optional<User> userContainer = userRepository.findById(Integer.toString(id));
        if(userContainer.isPresent())
            return userContainer.get();
        else{
            System.out.println("No existe el objeto");
            throw new Exception();
        }
    }

    @Override
    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    @Override
    public void deleteById( int id )
    {
        userRepository.deleteById(Integer.toString(id));
    }

    @Override
    public User update(User user, int id )
    {
        return userRepository.save(user);
    }
}
