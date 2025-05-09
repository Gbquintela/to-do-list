package com.to_do_list.to_do_list.controller;

import ch.qos.logback.core.model.Model;
import com.to_do_list.to_do_list.entity.User;
import com.to_do_list.to_do_list.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/login")
public class login {

    private final UserRepository userRepository;

    public login(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @PostMapping("/auth")
    public ModelAndView loginVerification(
            @RequestParam String cpf,
            @RequestParam String password,
            HttpSession session,
            Model model
    ){
        cpf = cpf.replaceAll("[^0-9]", "");

        User user = userRepository.findByCpfAndPassword(cpf, password);

        if(user != null){
            session.setAttribute("user", user);
            return new ModelAndView("redirect:/createTask");
        }else{
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "CPF ou senha incorretos");
            return modelAndView;
        }


    }
}
