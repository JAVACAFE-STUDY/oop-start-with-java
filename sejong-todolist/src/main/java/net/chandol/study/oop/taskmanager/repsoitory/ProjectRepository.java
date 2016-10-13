package net.chandol.study.oop.taskmanager.repsoitory;

import net.chandol.study.oop.taskmanager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
}
