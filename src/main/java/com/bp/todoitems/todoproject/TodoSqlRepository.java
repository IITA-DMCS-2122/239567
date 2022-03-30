package com.bp.todoitems.todoproject;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bp.todoitems.todoproject.TodoSqlEntity;

import javax.transaction.Transactional;
import java.util.UUID;

@Transactional
public interface TodoSqlRepository extends JpaRepository<TodoSqlEntity, Integer> {

    void deleteByUuid(String uuid);


}
