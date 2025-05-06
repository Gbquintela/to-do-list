package com.to_do_list.to_do_list.service.task;

import com.to_do_list.to_do_list.dto.TaskDTO;
import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class DeleteByIdService {

    private final TaskRepository taskRepository;

    public DeleteByIdService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public boolean deleteById (@PathVariable Long id){

        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return true;
        }

        return false;




    }

}
