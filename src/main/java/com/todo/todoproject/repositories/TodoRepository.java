package com.todo.todoproject.repositories;

import com.todo.todoproject.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    TodoEntity findByUsernameAndPassword(String username, String password);

    TodoEntity findTopByUsername(String username);

    TodoEntity findTopByPassword(String password);

}
