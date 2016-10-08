package net.chandol.study.oop.task.service;

import net.chandol.study.oop.task.dto.StatusCreateRequest;
import net.chandol.study.oop.task.model.Project;
import net.chandol.study.oop.task.model.Status;
import net.chandol.study.oop.task.repsoitory.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusService {

    @Autowired
    StatusRepository repository;

    @Transactional
    public Status create(Project project, StatusCreateRequest request){
        Status status = new Status(project, request.getName(), request.getOrder());
        return repository.save(status);
    }

    @Transactional
    List<Status> createInitialStatus(Project project){
        List<Status> statuses = new ArrayList<>();

        statuses.add(create(project, new StatusCreateRequest("TODO", 0)));
        statuses.add(create(project, new StatusCreateRequest("DOING", 1)));
        statuses.add(create(project, new StatusCreateRequest("DONE", 2)));

        return statuses;
    }

    public List<Status> findActiveStatuses(Project project){
        return repository.findActiveStatues(project);
    }
}
