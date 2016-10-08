package net.chandol.study.oop.taskmanager.service;

import net.chandol.study.oop.taskmanager.dto.ProjectCreateRequest;
import net.chandol.study.oop.taskmanager.model.Project;
import net.chandol.study.oop.taskmanager.model.Status;
import net.chandol.study.oop.taskmanager.repsoitory.StatusRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceTest {
    @Autowired
    ProjectService projectService;
    @Autowired
    StatusRepository statusRepository;

    @Test
    public void 프로젝트_생성(){
        //given
        ProjectCreateRequest request = new ProjectCreateRequest("집안일");

        //when
        Project project = projectService.createWithDefaultStatus(request);

        //then
        List<Status> statuses = statusRepository.findByProject(project);

        assertThat(statuses).asList().hasSize(3);
        assertThat(statuses.get(0).getName()).isEqualTo("TODO");
        assertThat(statuses.get(1).getName()).isEqualTo("DOING");
        assertThat(statuses.get(2).getName()).isEqualTo("DONE");
    }
}