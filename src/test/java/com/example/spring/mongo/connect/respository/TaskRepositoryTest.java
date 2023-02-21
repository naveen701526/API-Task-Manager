package com.example.spring.mongo.connect.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring.mongo.connect.model.Task;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testSaveTask() {
        // Create a new task
        Task task = new Task();
        task.setDescription("Buy groceries");

        // Save the task
        Task savedTask = taskRepository.save(task);

        // Verify that the task was saved
        assertNotNull(savedTask);
        assertNotNull(savedTask.getId());
        assertEquals("Buy groceries", savedTask.getDescription());
    }

    @Test
    public void testFindAllTasks() {
        // Create some test tasks
        Task task1 = new Task();
        task1.setDescription("Buy milk");
        taskRepository.save(task1);

        Task task2 = new Task();
        task2.setDescription("Clean the house");
        taskRepository.save(task2);

        // Find all tasks
        List<Task> tasks = taskRepository.findAll();

        // Verify that the tasks were found
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(2, tasks.size());
    }

    @Test
    public void testUpdateTask() {
        // Create a new task
        Task task = new Task();
        task.setDescription("Buy milk");
        Task savedTask = taskRepository.save(task);

        // Update the task
        savedTask.setDescription("Buy cheese");
        Task updatedTask = taskRepository.save(savedTask);

        // Verify that the task was updated
        assertNotNull(updatedTask);
        assertEquals(savedTask.getId(), updatedTask.getId());
        assertEquals("Buy cheese", updatedTask.getDescription());
    }

    @Test
    public void testDeleteTask() {
        // Create a new task
        Task task = new Task();
        task.setDescription("Buy bread");
        Task savedTask = taskRepository.save(task);

        // Delete the task
        taskRepository.deleteById(savedTask.getId());

        // Verify that the task was deleted
        Optional<Task> deletedTask = taskRepository.findById(savedTask.getId());
        assertNull(deletedTask.orElse(null));
    }

}
