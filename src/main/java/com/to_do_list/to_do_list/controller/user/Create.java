package com.to_do_list.to_do_list.controller.user;

import com.to_do_list.to_do_list.dto.UserDTO;
import com.to_do_list.to_do_list.entity.User;
import com.to_do_list.to_do_list.service.userService.CreateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Binding;

@RestController
@RequestMapping("/user")
public class Create {

    private  final CreateService createService;

    public Create(CreateService createService) {
        this.createService = createService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register( UserDTO userDTO){

        try{
            createService.createService(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao registrar usuario");

        }    }
}
