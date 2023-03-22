package com.projects.task_manager.controller;

import com.projects.task_manager.dto.TaskDTO;
import com.projects.task_manager.model.Task;
import com.projects.task_manager.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    ITaskService iTaskService;

    @GetMapping("/getAll")
    public List<TaskDTO> getAll(){
        return iTaskService.getAll();
    }

    @PostMapping("/add")
    public TaskDTO add(@RequestBody TaskDTO task){
        return iTaskService.add(task);
    }

    @GetMapping("/getById/{id}")
    public TaskDTO getTaskById(@PathVariable long id){
        return iTaskService.getTaskById(id);
    }

    @PutMapping("/update")
    public TaskDTO update(@RequestBody TaskDTO taskDTO){
        return iTaskService.update(taskDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable long id){
         return iTaskService.delete(id);
    }
}
