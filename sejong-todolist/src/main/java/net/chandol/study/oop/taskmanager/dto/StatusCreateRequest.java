package net.chandol.study.oop.taskmanager.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@ApiModel("상태 생성요청 DTO")
public class StatusCreateRequest {
    @ApiModelProperty(value = "상태명", required = true)
    @NotNull
    private String name;

    @ApiModelProperty(value = "순서", required = true)
    @NotNull
    private int order;
}
