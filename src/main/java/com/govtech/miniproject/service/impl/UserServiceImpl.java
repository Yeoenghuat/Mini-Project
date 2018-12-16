package com.govtech.miniproject.service.impl;

import com.govtech.miniproject.model.User;
import com.govtech.miniproject.repository.UserRepository;
import com.govtech.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * This method is used to compute the list of users
     * @param min minimum amount for the salary
     * @param max maximum amount for the salary
     * @return list of users with valid salary
     */
    @Override
    public List<User> getUsers(Double min, Double max) {
        List<User> userList = new ArrayList<User>();
        userList = userRepository.findAllBySalaryIsBetween(min, max);

        return userList;
    }
}
