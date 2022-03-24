package com.todo.todoproject.service;

import com.todo.todoproject.entity.TodoItemFromUser;
import com.todo.todoproject.entity.TodoItemSql;
import com.todo.todoproject.entity.TodoItemNoSql;
import com.todo.todoproject.repositories.NoSql.TodoItemNoSqlRepository;
import com.todo.todoproject.repositories.analytics.TodoItemAnalyticsRepository;
import com.todo.todoproject.repositories.sql.TodoItemSqlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class TodoService {


    private final TodoItemSqlRepository itemSqlRepository;
    private final TodoItemNoSqlRepository itemNoSqlRepository;
    private final TodoItemAnalyticsRepository itemAnalyticsRepository;

    public TodoItemFromUser getByUuid(String uuid) {
        TodoItemNoSql todoItemNoSql = itemNoSqlRepository.findByUuid(uuid);
        return new TodoItemFromUser(
                todoItemNoSql.getUuid(),
                todoItemNoSql.getUsername(),
                todoItemNoSql.getPassword());

    }



    public List<TodoItemFromUser> getAll() {
        List<TodoItemSql> todoItemsNoSql = itemNoSqlRepository.findAll();
        return todoItemsNoSql
                .stream()
                .map(item -> new TodoItemFromUser(item.getUuid(), item.getUsername(), item.getPassword()))
                .collect(Collectors.toList());
    }

    public void add(TodoItemFromUser itemFromUser) {
        itemFromUser.setUuid(UUID.randomUUID().toString());
        TodoItemSql todoItemSql = TodoItemSql
                .builder()
                .uuid(itemFromUser.getUuid())
                .username(itemFromUser.getUsername())
                .password(itemFromUser.getPassword())
                .build();
        itemSqlRepository.save(todoItemSql);
        itemAnalyticsRepository.save(todoItemSql);
        itemNoSqlRepository.save(
                TodoItemSql
                        .builder()
                        .id(todoItemSql.getId())
                        .uuid(todoItemSql.getUuid())
                        .username(todoItemSql.getUsername())
                        .password(todoItemSql.getPassword())
                        .build());
    }

    public void deleteByUuid(String uuid) {
        itemSqlRepository.deleteByUuid(uuid);
        itemNoSqlRepository.deleteByUuid(uuid);
    }

    public void update(TodoItemFromUser itemFromUser) {
        TodoItemNoSql itemNoSql = itemNoSqlRepository.findByUuid(itemFromUser.getUuid());
        itemNoSql.setUsername(itemFromUser.getUsername());
        itemNoSql.setPassword(itemFromUser.getPassword());
        itemNoSqlRepository.save(itemNoSql);
        itemSqlRepository.save(
                new TodoItemSql(
                        itemNoSql.getId(),
                        itemNoSql.getUuid(),
                        itemNoSql.getUsername(),
                        itemNoSql.getPassword()));
    }

    public List<TodoItemFromUser> search(String query) {
        return itemSqlRepository
                .search(query)
                .stream()
                .map(itemSql -> new TodoItemFromUser(itemSql.getUuid(), itemSql.getUsername(), itemSql.getPassword()))
                .collect(Collectors.toList());
    }

}
