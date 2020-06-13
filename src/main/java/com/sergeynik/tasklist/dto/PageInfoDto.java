package com.sergeynik.tasklist.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description = "Информация о странице пагинации")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageInfoDto {

    @ApiModelProperty(value = "Размер страницы", example = "10")
    private Integer size;

    @ApiModelProperty(value = "Общее число элементов", example = "100")
    private Long totalElements;

    @ApiModelProperty(value = "Общее число страниц", example = "10")
    private Integer totalPages;

    @ApiModelProperty(value = "Номер текущей страницы", example = "0")
    private Integer number;
}
