package com.to_do_list.to_do_list.dto;

import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.enums.StatusTask;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {

    @NotBlank(message = "Nome tem que ser preenchido!")
    @Size(min = 5, max = 40, message = "Quantidade de caracteres invalido!")
    private String taskName;

    @NotBlank(message = "Descrição deve ser preenchida!")
    @Size(max = 150, message = "Tamanho máximo da descrição é de 150 caracteres!")
    private String taskDescription;

    @NotNull
    @NotBlank(message = "Status deve ser marcado!")
    private StatusTask statusTask;

    private Long userId;

    public Task toTask(){
        Task task = new Task();

        task.setTaskName(taskName);
        task.setTaskDescription(taskDescription);
        task.setStatusTask(statusTask != null ? statusTask : StatusTask.PROGRESS);

        return task;
    }
}
