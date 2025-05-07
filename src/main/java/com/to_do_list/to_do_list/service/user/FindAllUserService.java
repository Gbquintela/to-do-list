package com.to_do_list.to_do_list.service.user;

import com.to_do_list.to_do_list.entity.User;
import com.to_do_list.to_do_list.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllUserService {

    private final UserRepository userRepository;

    public FindAllUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){


        return userRepository.findAll();
    }
}
