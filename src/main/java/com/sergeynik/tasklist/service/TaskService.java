package com.sergeynik.tasklist.service;

import com.sergeynik.tasklist.dto.PageDto;
import com.sergeynik.tasklist.dto.TaskDto;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    PageDto<TaskDto> getTasks(Pageable pageable);
}
