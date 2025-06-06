package com.to_do_list.to_do_list.controller.task;


import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.service.task.FindAllTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
public class FindAllTaskController {

    private final FindAllTaskService findAllTaskService;

    public FindAllTaskController(FindAllTaskService findAllTaskService) {
        this.findAllTaskService = findAllTaskService;
    }

    @GetMapping("/findAllTask")
    public ResponseEntity<?> findAllTask(){
        try {
            List<Task> taskList = findAllTaskService.getAllTask();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(taskList);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Erro ao lista as tarefas!");
        }
    }
}
