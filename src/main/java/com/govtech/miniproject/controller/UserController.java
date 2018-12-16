package com.govtech.miniproject.controller;

import com.govtech.miniproject.model.User;
import com.govtech.miniproject.model.response.UserResponse;
import com.govtech.miniproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * HTTP GET /users
     * Input   : n.a
     * Compute : Get user details
     * @return list of users with valid salary (0 <= salary <= 4000)
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity getUsers() {
        logger.debug("HTTP GET /users called");
        List<User> userList = userService.getUsers(0.00, 4000.00);

        return new ResponseEntity(new UserResponse(userList), HttpStatus.OK);
    }
}
