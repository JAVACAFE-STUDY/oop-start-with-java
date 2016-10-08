package net.chandol.study.oop.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatusCreateRequest {
    private String name;
    private Integer order;
}
