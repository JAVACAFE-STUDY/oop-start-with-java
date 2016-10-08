package net.chandol.study.oop.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskCreateRequest {
    private String name;
    private String description;
    private Integer order;
}
