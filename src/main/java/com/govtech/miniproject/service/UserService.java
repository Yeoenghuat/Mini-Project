package com.govtech.miniproject.service;

import com.govtech.miniproject.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers(Double min, Double max);
}
