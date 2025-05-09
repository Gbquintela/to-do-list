package com.to_do_list.to_do_list.service.user;


import com.to_do_list.to_do_list.dto.UserDTO;
import com.to_do_list.to_do_list.entity.User;
import com.to_do_list.to_do_list.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RegisterUserService {

private final UserRepository userRepository;

    public RegisterUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerService(@RequestBody UserDTO userDTO){
        return userRepository.save(userDTO.toUser());
    }
}
