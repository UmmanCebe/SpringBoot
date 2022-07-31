package com.example.springEgitim.services.Impl;

import com.example.springEgitim.core.entities.User;
import com.example.springEgitim.core.repository.UserRepository;
import com.example.springEgitim.core.utilities.results.DataResult;
import com.example.springEgitim.core.utilities.results.Result;
import com.example.springEgitim.core.utilities.results.SuccessDataResult;
import com.example.springEgitim.core.utilities.results.SuccessResult;
import com.example.springEgitim.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Result add(User user) {
        this.userRepository.save(user);
        return new SuccessResult("Kullanıcı eklendi");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userRepository.findByEmail(email),"Kullanıcı bulundu");
    }
}
