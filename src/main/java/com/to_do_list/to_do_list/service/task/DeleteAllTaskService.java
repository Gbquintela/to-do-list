package com.to_do_list.to_do_list.service.task;


import com.to_do_list.to_do_list.dto.TaskDTO;
import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteAllTaskService {


    private final TaskRepository taskRepository;


    public DeleteAllTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public boolean deleteAllTask(){

        List<Task> existingTask = this.taskRepository.findAll();

        if(existingTask.isEmpty()){

            return false;

        }

        taskRepository.deleteAll();

        return true;




    }


}
