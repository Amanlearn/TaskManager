package com.projects.task_manager.service;

import com.projects.task_manager.dto.TaskDTO;
import javafx.concurrent.Task;

import java.util.List;

public interface ITaskService {
    public List<TaskDTO> getAll();
    public TaskDTO add(TaskDTO task);
    public TaskDTO getTaskById(long id);
}
