package net.chandol.study.oop.taskmanager;

import io.swagger.annotations.ApiOperation;
import net.chandol.study.oop.taskmanager.dto.ProjectCreateRequest;
import net.chandol.study.oop.taskmanager.dto.StatusCreateRequest;
import net.chandol.study.oop.taskmanager.dto.TaskCreateRequest;
import net.chandol.study.oop.taskmanager.model.Project;
import net.chandol.study.oop.taskmanager.model.Status;
import net.chandol.study.oop.taskmanager.model.Task;
import net.chandol.study.oop.taskmanager.repsoitory.ProjectRepository;
import net.chandol.study.oop.taskmanager.service.ProjectService;
import net.chandol.study.oop.taskmanager.service.StatusService;
import net.chandol.study.oop.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskManagerRestController {

    @Autowired ProjectRepository projectRepository;
    @Autowired ProjectService projectService;
    @Autowired StatusService statusService;
    @Autowired TaskService taskService;

    @ApiOperation("모든 프로젝트 반환")
    @GetMapping("/project")
    ResponseEntity<List<Project>> getAllProjects() {

        return ResponseEntity.ok(projectRepository.findAll());
    }

    @ApiOperation("특정 프로젝트 반환")
    @GetMapping("/project/{projectId}")
    ResponseEntity<Project> getProject(
            @PathVariable("projectId") Project project) {

        return ResponseEntity.ok(project);
    }

    @ApiOperation("프로젝트 생성")
    @PostMapping("/project")
    ResponseEntity<Project> createProject(
            @RequestBody ProjectCreateRequest request) {

        Project project = projectService.createWithDefaultStatus(request);
        return ResponseEntity.ok(project);
    }

    @ApiOperation("활성화된 상태 반환")
    @GetMapping("/project/{projectId}/status")
    ResponseEntity<List<Status>> getActiveStatuse(
            @PathVariable("projectId") Project project) {

        List<Status> statuses = statusService.findActiveStatuses(project);
        return ResponseEntity.ok(statuses);
    }

    @ApiOperation("상태 추가하기")
    @PostMapping("/project/{projectId}/status")
    ResponseEntity<Status> createActiveStatuse(
            @PathVariable("projectId") Project project,
            @RequestBody StatusCreateRequest statusCreateRequest) {

        Status status = statusService.create(project, statusCreateRequest);
        return ResponseEntity.ok(status);
    }

    @ApiOperation("작업 추가하기")
    @PostMapping("/project/{projectId}/status/{statusId}/task")
    ResponseEntity<Task> createTask(
            @PathVariable("projectId") Project project,
            @PathVariable("statusId") Status status,
            @RequestBody TaskCreateRequest request) {

        //TODO validation 처리(계층관계가 맞는지에 대해서 체크체크!!)
        return ResponseEntity.ok(taskService.create(status, request));
    }

    @ApiOperation("작업 정보 보기")
    @GetMapping("/project/{projectId}/status/{statusId}/task/{taskId}")
    ResponseEntity<Task> getTask(
            @PathVariable("projectId") Project project,
            @PathVariable("statusId") Status status,
            @PathVariable("taskId") Task task){

        //TODO 역시 validation 처리 필요
        return ResponseEntity.ok(task);
    }

}
