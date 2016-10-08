package net.chandol.study.oop.taskmanager.service;

import net.chandol.study.oop.taskmanager.dto.ProjectCreateRequest;
import net.chandol.study.oop.taskmanager.model.Project;
import net.chandol.study.oop.taskmanager.repsoitory.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository repository;
    @Autowired
    StatusService statusService;

    @Transactional
    public Project createWithDefaultStatus(ProjectCreateRequest request) {
        Project project = repository.save(new Project(request.getName()));
        // 기본상태 TO-DO, DOING, DONE Status를 생성한다.
        statusService.createInitialStatus(project);
        return project;
    }

}
