package com.lcwr.validation_exception_handling.validation_exception_handling.service;

import com.lcwr.validation_exception_handling.validation_exception_handling.dto.UserRequest;
import com.lcwr.validation_exception_handling.validation_exception_handling.entity.User;
import com.lcwr.validation_exception_handling.validation_exception_handling.exception.UserNotFoundException;
import com.lcwr.validation_exception_handling.validation_exception_handling.repository.UserRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepositroy userRepositroy;

    public User saveUser(UserRequest userRequest) {
        User user = User.
                build(0,userRequest.getName(),userRequest.getEmail(),userRequest.getMobile(),userRequest.getGender(),userRequest.getAge(),userRequest.getNationality());

        return userRepositroy.save(user);
    }

    public List<User> getAllUsers() {
        return userRepositroy.findAll();
    }

    public User getUserById(int id) throws UserNotFoundException{
        User user = userRepositroy.findByUserId(id);
        if( user!= null) {
            return user;
        } else {
            throw new UserNotFoundException("user is not found for this id: " + id);
        }
    }
}
