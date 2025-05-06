package com.to_do_list.to_do_list.service.task;


import com.to_do_list.to_do_list.dto.TaskDTO;
import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UpdateTaskService {

    private final TaskRepository taskRepository;

    public UpdateTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        Optional<Task> taskExists = taskRepository.findById(id);
        if(taskExists.isPresent()){
            Task task = taskRepository.getReferenceById(id);

            Task taskUpdate = taskRepository.save(task);
            return taskRepository.save(taskUpdate);
        }

        return taskRepository.save(taskDTO.toTask());
    }
}
