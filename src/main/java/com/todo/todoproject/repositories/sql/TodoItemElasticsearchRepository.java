package com.todo.todoproject.repositories.sql;

import com.todo.todoproject.entity.TodoItemSql;

import java.util.List;

public interface TodoItemElasticsearchRepository {
    List<TodoItemSql> search(String query);
}
