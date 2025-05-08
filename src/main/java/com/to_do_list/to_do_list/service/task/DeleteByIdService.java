package com.to_do_list.to_do_list.service.task;

import com.to_do_list.to_do_list.dto.TaskDTO;
import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class DeleteByIdService {

    private final TaskRepository taskRepository;

    public DeleteByIdService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public ResponseEntity<Task> deleteById (@PathVariable Long id){
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            taskRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public Optional<Task> findById(Long id) { return taskRepository.findById(id);}
}
