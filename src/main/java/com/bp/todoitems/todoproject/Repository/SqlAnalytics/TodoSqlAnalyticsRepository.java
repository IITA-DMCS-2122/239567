package com.bp.todoitems.todoproject.Repository.SqlAnalytics;

import com.bp.todoitems.todoproject.Entity.Sql.TodoSqlEntity;
import com.bp.todoitems.todoproject.Entity.SqlAnalytics.TodoSqlAnalyticsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TodoSqlAnalyticsRepository extends JpaRepository<TodoSqlAnalyticsEntity, Integer> {

    void deleteByUuid(String uuid);

}
