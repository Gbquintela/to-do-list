package com.to_do_list.to_do_list.controller.task;


import com.to_do_list.to_do_list.dto.TaskDTO;
import com.to_do_list.to_do_list.service.task.UpdateTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class UpdateTaskController {

    private final UpdateTaskService updateTaskService;



    public UpdateTaskController(UpdateTaskService updateTaskService) {
        this.updateTaskService = updateTaskService;
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, TaskDTO taskDTO){
        Optional<Task> task = updateTaskService.findById(id);
        if (task.isPresent()) {
            updateTaskService.updateTask(id, taskDTO);
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(task);
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Erro ao procurar tarefa pelo id");

    }

    }

