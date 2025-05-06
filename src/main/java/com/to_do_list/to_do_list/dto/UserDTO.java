package com.to_do_list.to_do_list.dto;

import com.to_do_list.to_do_list.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
@Getter
@Setter
public class UserDTO {

    @NotBlank
    @Size(max = 80, message = "Limite de caracteres excedido!")
    private String username;

    @CPF(message = "CPF inválido!")
    @NotBlank(message = "CPF não pode estar vazio!")
    private String cpf;

    @NotBlank(message = "Senha não pode ficar vazia!")
    @Size(min = 8, max = 40, message = "Número de caracteres inválidos!")
    private String password;

    @NotBlank(message = "Confirmação de Senha não pode ficar vazia!")
    @Size(min = 8, max = 40, message = "Número de caracteres inválidos!")
    private String confirmPassword;

    public User toUser(){
        User user = new User();

        user.setUsername(username);
        user.setCpf(cpf);
        user.setPassword(password);

        return user;
    }
}
