package net.chandol.study.oop.taskmanager.service;

import net.chandol.study.oop.taskmanager.dto.ProjectCreateRequest;
import net.chandol.study.oop.taskmanager.dto.TaskCreateRequest;
import net.chandol.study.oop.taskmanager.model.Project;
import net.chandol.study.oop.taskmanager.model.Status;
import net.chandol.study.oop.taskmanager.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static net.chandol.study.oop._testutil.SejongAssert.objectAssertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {

    @Autowired
    ProjectService projectService;
    @Autowired
    StatusService statusService;
    @Autowired
    TaskService taskService;

    private Project fixtureProject;

    @Before
    public void setup(){
        fixtureProject = projectService.createWithDefaultStatus(new ProjectCreateRequest("프로젝트"));
    }

    @Test
    public void 태스크생성하기(){
        // given
        Project project = fixtureProject;
        Status status = statusService.findActiveStatuses(project).get(0);

        // when
        Task task = taskService.create(status, new TaskCreateRequest("작업", "설명", 0));

        // then
        objectAssertThat(task)
                .is("name", "작업")
                .is("description", "설명")
                .is("order", 0);
    }
}