package com.govtech.miniproject.model.response;

import com.govtech.miniproject.model.User;

import java.util.List;

public class UserResponse {
    private List<User> results;

    public UserResponse(List<User> results) {
        this.results = results;
    }

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }
}
