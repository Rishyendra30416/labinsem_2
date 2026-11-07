
package com.example.repositorytesting.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.repositorytesting.entity.Task;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testSaveAndFindTask() {

        Task task = new Task(
            "Complete Assignment",
            "Spring Boot JPA Testing",
            false
        );

        Task savedTask = taskRepository.save(task);

        assertNotNull(savedTask.getId());

        Task foundTask = taskRepository
                .findById(savedTask.getId())
                .orElse(null);

        assertNotNull(foundTask);

        assertEquals(
            "Complete Assignment",
            foundTask.getTitle()
        );

        System.out.println("Task saved successfully!");
        System.out.println("Task ID: " + foundTask.getId());
        System.out.println("Task Title: " + foundTask.getTitle());
    }
}
