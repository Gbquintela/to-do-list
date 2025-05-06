package com.to_do_list.to_do_list.controller.task;


import com.to_do_list.to_do_list.service.task.DeleteAllTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class DeleteAllTaskController {

    private final DeleteAllTaskService deleteAllTaskService;


    public DeleteAllTaskController(DeleteAllTaskService deleteAllTaskService) {
        this.deleteAllTaskService = deleteAllTaskService;
    }


    @DeleteMapping("/delete/all")
    public ResponseEntity<String> deleteAllTask(){

        try {
                deleteAllTaskService.deleteAllTask();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Todas as tarefas deletada com sucesso!");
        } catch (Exception e){

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao deletar as tarefas");

        }
    }
}
