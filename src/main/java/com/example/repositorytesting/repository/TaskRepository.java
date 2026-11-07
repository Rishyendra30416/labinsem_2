
package com.example.repositorytesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.repositorytesting.entity.Task;

public interface TaskRepository
        extends JpaRepository<Task, Long> {

}
