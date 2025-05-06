package com.to_do_list.to_do_list.service.userService;


import com.to_do_list.to_do_list.dto.UserDTO;
import com.to_do_list.to_do_list.entity.User;
import com.to_do_list.to_do_list.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CreateService {

private final UserRepository userRepository;

    public CreateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createService(@RequestBody UserDTO userDTO){

        User user = new User();

        user.setUsername(userDTO.getUsername());
        user.setCpf(userDTO.getCpf());
        user.setPassword(userDTO.getPassword());


        return userRepository.save(user);

    }
}
