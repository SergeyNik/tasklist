package com.sergeynik.tasklist.converter;

import com.sergeynik.tasklist.dto.TaskDto;
import com.sergeynik.tasklist.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class TaskDtoConverter {

    public TaskDto fromDomain(Task task) {
        if (isNull(task)) return null;

        return new TaskDto(
                task.getId(),
                task.getHeader(),
                task.getDescription()
        );
    }
}
