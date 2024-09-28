package com.javaguru.springbootmongoatlas.repository;

import com.javaguru.springbootmongoatlas.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findBySeverity(String severity);

    @Query("{assignee: ?0}")
    List<Task> getTasksByAssignee(String assignee);
}