package com.projects.task_manager.dao;

import com.projects.task_manager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskDAO extends JpaRepository<Task, Long> {
}
