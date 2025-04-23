package com.structura.project.core.task.port.out.persistence;

import com.structura.project.core.task.model.Task;
import com.structura.project.core.task.model.TaskCriteria;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);

    void deleteById(String eq);

    List<Task> getTasks(TaskCriteria criteria);
}
