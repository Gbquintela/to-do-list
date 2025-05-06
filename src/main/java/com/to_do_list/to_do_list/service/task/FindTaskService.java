package com.to_do_list.to_do_list.service.task;


import com.to_do_list.to_do_list.dto.TaskDTO;
import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FindTaskService {

    private final TaskRepository taskRepository;


    public FindTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTask(){


        return taskRepository.findAll();

    }
}
