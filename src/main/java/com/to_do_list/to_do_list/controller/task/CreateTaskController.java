package com.to_do_list.to_do_list.controller.task;


import com.to_do_list.to_do_list.dto.TaskDTO;
import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.service.task.CreateTaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class CreateTaskController {

    private final CreateTaskService createTaskService;

    public CreateTaskController(CreateTaskService createTaskService) {
        this.createTaskService = createTaskService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTask(
            @RequestBody TaskDTO taskDTO,
            @RequestParam Long userId) {

        try {
            Task createdTask = createTaskService.createService(taskDTO, userId);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdTask);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao criar a tarefa: " + e.getMessage());
        }
    }
}
