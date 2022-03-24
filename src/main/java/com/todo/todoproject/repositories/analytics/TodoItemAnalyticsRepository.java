package com.todo.todoproject.repositories.analytics;

import com.todo.todoproject.entity.TodoItemSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface TodoItemAnalyticsRepository extends JpaRepository<TodoItemSql, Integer> {
}
