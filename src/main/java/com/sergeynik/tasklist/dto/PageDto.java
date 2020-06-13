package com.sergeynik.tasklist.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@ApiModel(description = "Страница пагинации с данными")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageDto<T> {

    @ApiModelProperty(value = "Список сущностей")
    private List<T> data;

    @ApiModelProperty(value = "Информация о странице")
    private PageInfoDto page;
}
