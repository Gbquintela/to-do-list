package com.to_do_list.to_do_list.service.task;

import com.to_do_list.to_do_list.dto.TaskDTO;
import com.to_do_list.to_do_list.entity.Task;
import com.to_do_list.to_do_list.entity.User;
import com.to_do_list.to_do_list.repository.TaskRepository;
import com.to_do_list.to_do_list.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CreateTaskService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public CreateTaskService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public Task createService(
            @RequestBody TaskDTO taskDTO,
            @RequestParam Long userId
    ){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("Usuario não encontrado com ID: " + userId));

        Task task = taskDTO.toTask();
        task.setUser(user);

        return taskRepository.save(task);
    }
}
