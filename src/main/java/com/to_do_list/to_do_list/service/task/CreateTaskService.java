package com.to_do_list.to_do_list.service.task;

import com.to_do_list.to_do_list.dto.TaskDTO;
import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CreateTaskService {

    private final TaskRepository taskRepository;

    public CreateTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createService(@RequestBody TaskDTO taskDTO){
        Task task = new Task();

        return taskRepository.save(taskDTO.toTask());
    }
}
