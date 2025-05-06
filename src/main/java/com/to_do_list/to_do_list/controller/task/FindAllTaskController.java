package com.to_do_list.to_do_list.controller.task;


import com.to_do_list.to_do_list.dto.TaskDTO;
import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.service.task.FindTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/task")
public class FindAllTaskController {

    private final FindTaskService findTaskService;

    public FindAllTaskController(FindTaskService findTaskService) {
        this.findTaskService = findTaskService;
    }


    @GetMapping("/findAll")
    public ResponseEntity<?> findAllTask(){
        try {

           List<Task> taskList = findTaskService.getAllTask();

            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(taskList);


        } catch (Exception e){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao lista as tarefas!");



        }


    }
}
