package com.example.springEgitim.services;

import com.example.springEgitim.core.entities.User;
import com.example.springEgitim.core.utilities.results.DataResult;
import com.example.springEgitim.core.utilities.results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
