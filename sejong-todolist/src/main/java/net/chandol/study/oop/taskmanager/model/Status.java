package net.chandol.study.oop.taskmanager.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static net.chandol.study.oop.common.SejongVerifier.verifyNotEmpty;
import static net.chandol.study.oop.common.SejongVerifier.verifyNotNull;

@Entity
@Getter
public class Status {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer sortValue;
    @ManyToOne
    private Project project;
    private boolean archive;

    @OneToMany(mappedBy = "status", fetch = EAGER)
    @OrderBy("order")
    private List<Task> tasks = new ArrayList<>();

    protected Status() {}

    public Status(Project project, String name, Integer sortValue) {
        this.setProject(project);
        this.setName(name);
        this.setSortValue(sortValue);
        this.archive = false;
    }

    private void setProject(Project project) {
        verifyNotNull(project);

        this.project = project;
    }

    public void setName(String name) {
        verifyNotEmpty(name);
        this.name = name;
    }

    public void setSortValue(int sortValue) {
        verifyOrderBiggerThanZero(sortValue);
        this.sortValue = sortValue;
    }

    public void archive(){
        this.archive = true;
    }

    void removeTask(Task task) {
        this.tasks.remove(task);
    }

    void addTask(Task task) {
        this.tasks.add(task);
    }

    private void verifyOrderBiggerThanZero(int order) {
        if (order < 0){
            throw new IllegalArgumentException("order는 0보다 커야 합니다.");
        }
    }
}
