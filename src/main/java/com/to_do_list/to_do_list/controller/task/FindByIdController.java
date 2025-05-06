package com.to_do_list.to_do_list.controller.task;

import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.service.task.FindTaskByIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/task")
public class FindByIdController {

    private final FindTaskByIdService findTaskByIdService;

    public FindByIdController(FindTaskByIdService findTaskByIdService) {
        this.findTaskByIdService = findTaskByIdService;
    }

    @GetMapping("/findTask/{id}")
    public ResponseEntity<?> findById(Long id) {
        Optional<Task> task = findTaskByIdService.findById(id);
        if (task.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(task);
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Erro ao procurar tarefa pelo id");

    }
}
