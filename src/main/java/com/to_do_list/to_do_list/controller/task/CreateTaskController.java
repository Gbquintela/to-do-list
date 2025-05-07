package com.to_do_list.to_do_list.controller.task;


import com.to_do_list.to_do_list.dto.TaskDTO;
import com.to_do_list.to_do_list.service.task.CreateTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class CreateTaskController {

    private final CreateTaskService createTaskService;

    public CreateTaskController(CreateTaskService createTaskService) {
        this.createTaskService = createTaskService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createTask(TaskDTO taskDTO) {

        try {
            createTaskService.createService(taskDTO);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Tarefa criada com sucesso");

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao criar a tarefa!");
        }
    }
}
