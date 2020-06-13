package com.sergeynik.tasklist.service;

import com.sergeynik.tasklist.converter.PageDtoConverter;
import com.sergeynik.tasklist.converter.TaskDtoConverter;
import com.sergeynik.tasklist.dto.PageDto;
import com.sergeynik.tasklist.dto.TaskDto;
import com.sergeynik.tasklist.model.Task;
import com.sergeynik.tasklist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskDtoConverter taskDtoConverter;
    private final PageDtoConverter pageDtoConverter;

    @Override
    public PageDto<TaskDto> getTasks(Pageable pageable) {
        Page<Task> codes = taskRepository.findAll(pageable);
        return pageDtoConverter.fromDomain(codes, taskDtoConverter::fromDomain);
    }
}
