package com.todo.todoproject.repositories.sql;

import com.todo.todoproject.entity.TodoItemSql;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.transaction.Transactional;

@Transactional
public interface TodoItemSqlRepository extends JpaRepository<TodoItemSql, Integer> {

        void deleteByUuid(String uuid);

}
