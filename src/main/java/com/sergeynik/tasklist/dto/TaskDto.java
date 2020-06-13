package com.sergeynik.tasklist.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@ApiModel(description = "Задача")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDto {

    @ApiModelProperty(value = "Идентификатор задачи", example = "8a7482ea-7777-8888-9999-764dcda50006")
    @JsonProperty(value = "id", required = true)
    private UUID id;

    @ApiModelProperty(value = "Заголовок задачи", example = "Задача 1")
    @JsonProperty(value = "header")
    private String header;

    @ApiModelProperty(value = "Описание задачи", example = "Сделать домашнее задание")
    @JsonProperty(value = "description", required = true)
    private String description;
}
