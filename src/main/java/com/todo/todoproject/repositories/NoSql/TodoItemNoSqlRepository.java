package com.todo.todoproject.repositories.NoSql;

import com.todo.todoproject.entity.TodoItemNoSql;
import com.todo.todoproject.entity.TodoItemSql;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.transaction.Transactional;

@Transactional
public interface TodoItemNoSqlRepository extends MongoRepository<TodoItemSql, Integer> {

    TodoItemNoSql findByUuid(String uuid);

    void  deleteByUuid(String uuid);
}
