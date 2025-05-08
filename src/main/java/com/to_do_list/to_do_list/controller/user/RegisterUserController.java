package com.to_do_list.to_do_list.controller.user;

import com.to_do_list.to_do_list.dto.UserDTO;
import com.to_do_list.to_do_list.service.user.RegisterUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class RegisterUserController {

    private final RegisterUserService registerUserService;

    public RegisterUserController(RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }

    @GetMapping("/register")
    public ModelAndView registerScreen(){
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(UserDTO userDTO) {

        try {
            registerUserService.registerService(userDTO);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Usuário registrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao registrar usuário");
        }
    }
}