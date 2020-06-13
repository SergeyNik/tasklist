package com.sergeynik.tasklist;

import com.sergeynik.tasklist.dto.PageDto;
import com.sergeynik.tasklist.dto.TaskDto;
import com.sergeynik.tasklist.service.TaskServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SwaggerDefinition(tags = {
        @Tag(name = "tasks", description = "Задачи")
})
@RestController
@RequiredArgsConstructor
public class TaskController {

    private final TaskServiceImpl taskService;

    @ApiOperation("Получить список задач")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Выполнено")
    })
    @GetMapping("/tasks")
    public PageDto<TaskDto> getTasks(Pageable pageable) {
        return taskService.getTasks(pageable);
    }
}
