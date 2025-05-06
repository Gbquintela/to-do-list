package com.to_do_list.to_do_list.dto;

import com.to_do_list.to_do_list.enums.StatusTask;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {

    @NotBlank(message = "Descrição deve ser preenchida!")
    @Size(max = 150, message = "Tamanho máximo da descrição é de 150 caracteres!")
    private String description;

    @NotBlank(message = "Status deve ser marcado!")
    private StatusTask statusTask;
}
