package net.chandol.study.oop.taskmanager.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@ApiModel("프로젝트 생성요청 DTO")
public class ProjectCreateRequest {

    @ApiModelProperty(value = "프로젝트명", required = true)
    @NotNull
    private String name;
}
