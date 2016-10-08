package net.chandol.study.oop.taskmanager.repsoitory;

import net.chandol.study.oop.taskmanager.model.Project;
import net.chandol.study.oop.taskmanager.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>, StatusRepositoryCustom{
    List<Status> findByProject(Project project);
}

interface StatusRepositoryCustom {
    List<Status> findActiveStatues(Project project);
}
