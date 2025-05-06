package com.to_do_list.to_do_list.service.task;


import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllTaskService {

    private final TaskRepository taskRepository;


    public FindAllTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTask(){


        return taskRepository.findAll();

    }
}
