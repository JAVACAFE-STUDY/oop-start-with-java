package net.chandol.study.oop.task.service;

import net.chandol.study.oop.task.dto.TaskCreateRequest;
import net.chandol.study.oop.task.model.Status;
import net.chandol.study.oop.task.model.Task;
import net.chandol.study.oop.task.repsoitory.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskService {

    @Autowired
    TaskRepository repository;

    @Transactional
    public Task create(Status status, TaskCreateRequest request){
        Task task = new Task(status, request.getName(),request.getDescription(), request.getOrder());

        return repository.save(task);
    }
}
