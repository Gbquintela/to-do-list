package com.to_do_list.to_do_list.controller.user;


import com.to_do_list.to_do_list.entity.User;
import com.to_do_list.to_do_list.service.user.FindAllUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class FindAllUserController {


    private final FindAllUserService findAllUserService;

    public FindAllUserController(FindAllUserService findAllUserService) {
        this.findAllUserService = findAllUserService;
    }


    @GetMapping("/findAllUsers")
    public ResponseEntity<?> findAllUsers(){
        List<User> userList= findAllUserService.findAll();
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userList);

        } catch (Exception e){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao listar todos os usuarios.");



        }

    }
}
