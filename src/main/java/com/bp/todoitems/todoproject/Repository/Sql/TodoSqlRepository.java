package com.bp.todoitems.todoproject.Repository.Sql;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bp.todoitems.todoproject.Entity.Sql.TodoSqlEntity;

import javax.transaction.Transactional;

@Transactional
public interface TodoSqlRepository extends JpaRepository<TodoSqlEntity, Integer> {

    void deleteByUuid(String uuid);


}
