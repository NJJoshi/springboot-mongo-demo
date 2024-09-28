package com.javaguru.springbootmongoatlas.service;

import com.javaguru.springbootmongoatlas.model.Task;
import com.javaguru.springbootmongoatlas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    //Create
    public Task addTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString());
        return taskRepository.save(task);
    }

    //READ
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task findTaskById(UUID taskId) {
        return taskRepository.findById(taskId.toString()).orElse(null);
    }

    public List<Task> findBySeverity(String severity) {
        return taskRepository.findBySeverity(severity);
    }

    public List<Task> getTasksByAssignee(String assignee) {
        return taskRepository.getTasksByAssignee(assignee);
    }

    //UPDATE
    public Task updateTask(Task task) {
        //get existing document from DB
        Task existingTask = taskRepository.findById(task.getTaskId()).orElse(null);

        //populate new value from request to existing object/entity/document
        existingTask.setTaskId(task.getTaskId());
        existingTask.setAssignee(task.getAssignee());
        existingTask.setDescription(task.getDescription());
        existingTask.setAssignee(task.getAssignee());
        existingTask.setStoryPoints(task.getStoryPoints());

        return taskRepository.save(task);
    }

    //DELETE
    public void deleteTask(UUID taskId) {
        taskRepository.deleteById(taskId.toString());
    }
}
