package net.chandol.study.oop.taskmanager.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@ApiModel("작업 생성요청 DTO")
public class TaskCreateRequest {
    @ApiModelProperty(value = "작업명", required = true)
    @NotNull
    private String name;
    @ApiModelProperty(value = "작업 상세")
    private String description;
    @ApiModelProperty(value = "순서")
    @NotNull
    private Integer order;
}
