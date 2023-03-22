package com.projects.task_manager.service;

import com.projects.task_manager.dao.ITaskDAO;
import com.projects.task_manager.dto.TaskDTO;
import com.projects.task_manager.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {
    @Autowired
    ITaskDAO iTaskDAO;


    public TaskDTO getTaskById(long id) {
        Task taskById = iTaskDAO.findById(id).get();
        return convertTaskTOTaskDTO(taskById);
    }

    public List<TaskDTO> getAll() {
        List<Task> ListTask = iTaskDAO.findAll();
        return convertListTaskToListTaskDTO(ListTask);
    }

    public List<TaskDTO> convertListTaskToListTaskDTO(List<Task> ListTask) {
        List<TaskDTO> listTaskDTO = new ArrayList<>();
        for (Task value : ListTask) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(value.getId());
            taskDTO.setTitle(value.getTitle());
            taskDTO.setDescription(value.getDescription());
            taskDTO.setDeadLine(value.getDeadLine());
            taskDTO.setCompleted(value.isCompleted());
            listTaskDTO.add(taskDTO);
        }
        return listTaskDTO;
    }


    public TaskDTO add(TaskDTO task) {
        Task taskMo = convertTaskDTOTOTask(task);
        Task task1 = iTaskDAO.save(taskMo);
        System.out.println("successfully added : " + task1);
        return convertTaskTOTaskDTO(task1);
    }

    public Task convertTaskDTOTOTask(TaskDTO task) {
        Task taskM = new Task();
        taskM.setTitle(task.getTitle());
        taskM.setDescription(task.getDescription());
        taskM.setDeadLine(task.getDeadLine());
        taskM.setCompleted(false);
        return taskM;
    }

    public TaskDTO convertTaskTOTaskDTO(Task task1) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task1.getId());
        taskDTO.setTitle(task1.getTitle());
        taskDTO.setDescription(task1.getDescription());
        taskDTO.setDeadLine(task1.getDeadLine());
        taskDTO.setCompleted(task1.isCompleted());
        return taskDTO;
    }

    public TaskDTO update(TaskDTO taskDTO) {
        long id = taskDTO.getId();
        Task taskM = iTaskDAO.findById(id).get();
        taskM.setTitle(taskDTO.getTitle());
        taskM.setDescription(taskDTO.getDescription());
        taskM.setDeadLine(taskDTO.getDeadLine());
        taskM.setCompleted(taskDTO.isCompleted());
        System.out.println("Updated task : " + taskM);
        Task taskUpdated = iTaskDAO.save(taskM);
        return convertTaskTOTaskDTO(taskUpdated);
    }

    public String delete(long id){
        iTaskDAO.deleteById(id);
        return "successfully deleted";
    }
}
