package net.chandol.study.oop.task.service;

import net.chandol.study.oop.task.dto.ProjectCreateRequest;
import net.chandol.study.oop.task.dto.StatusCreateRequest;
import net.chandol.study.oop.task.model.Project;
import net.chandol.study.oop.task.model.Status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static net.chandol.study.oop._testutil.SejongAssert.objectAssertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StatusServiceTest {
    @Autowired
    StatusService statusService;
    @Autowired
    ProjectService projectService;


    private Project fixtureProject;

    @Before
    public void setup(){
        // TODO project생성은 fixture 생성 클래스로 위임할 것.
        this.fixtureProject = projectService.createWithDefaultStatus(new ProjectCreateRequest("프로젝트"));
    }

    @Test
    @Transactional
    public void 상태생성_테스트() throws Exception {
        //given
        StatusCreateRequest request = new StatusCreateRequest("상태", 0);

        //when
        Status status = statusService.create(fixtureProject, request);

        //then
        objectAssertThat(status)
                .is("name", "상태")
                .is("order", 0)
                .is("fixtureProject.name", "프로젝트");
    }

    @Test
    @Transactional
    public void 활성화상태_반환_테스트(){
        //given
        // 기본생성된 활성상태가 3개 존재함.
        Project project = fixtureProject;

        //when, then
        List<Status> statuses = statusService.findActiveStatuses(project);

        assertThat(statuses).hasSize(3)
                .extracting("name", "order")
                .containsSequence(
                        tuple("TODO", 0),
                        tuple("DOING", 1),
                        tuple("DONE", 2));

        //when, then

        //첫번째 상태를 보관상태로 변경
        statuses.get(0).archive();
        List<Status> changedStatuses = statusService.findActiveStatuses(project);

        assertThat(changedStatuses).hasSize(2)
                .extracting("name", "order")
                .containsSequence(
                        tuple("DOING", 1),
                        tuple("DONE", 2));
    }
}