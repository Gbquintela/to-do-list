package com.to_do_list.to_do_list.controller.task;


import com.to_do_list.to_do_list.service.task.DeleteByIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class DeleteByIdController {

    private final DeleteByIdService deleteByIdService;

    public DeleteByIdController(DeleteByIdService deleteByIdService) {
        this.deleteByIdService = deleteByIdService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {

        try {
            deleteByIdService.deleteById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Tarefa Deletada com sucesso!");

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao deleta tarefa pelo id");
        }
    }
}
