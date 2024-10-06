package com.hhplus.hhplus2week.user.application;

import com.hhplus.hhplus2week.user.persistence.UserRepository;
import com.hhplus.hhplus2week.user.domain.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User saveUser(String name, String mobile){
        User user = new User();
        user.setName(name);
        user.setMobile(mobile);
        userRepository.save(user);
        return user;
    }

    @Transactional
    public User updateUser(User user){
        User findUser = this.getUser(user.getId());
        findUser.setMobile(user.getMobile());
        findUser.setName(user.getName());
        userRepository.save(user);
        return user;
    }

    public User getUser(long userId){
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("아이디에 해당하는 유저 없음"));
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
