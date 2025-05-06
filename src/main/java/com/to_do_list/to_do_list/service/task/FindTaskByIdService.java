package com.to_do_list.to_do_list.service.task;


import com.to_do_list.to_do_list.dto.TaskDTO;
import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class FindTaskByIdService {

    private final TaskRepository taskRepository;

    public FindTaskByIdService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional<Task> findById(@PathVariable Long id){



       return taskRepository.findById(id);


    }
}
