package com.todo.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.app.Model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{

}
