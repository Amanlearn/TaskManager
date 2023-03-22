package com.projects.task_manager.service;

import com.projects.task_manager.dto.TaskDTO;
import javafx.concurrent.Task;

import java.util.List;

public interface ITaskService {
    List<TaskDTO> getAll();

    TaskDTO add(TaskDTO task);

    TaskDTO getTaskById(long id);

    TaskDTO update(TaskDTO taskDTO);

    String delete(long id);

}
