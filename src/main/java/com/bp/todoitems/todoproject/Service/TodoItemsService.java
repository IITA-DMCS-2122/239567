package com.bp.todoitems.todoproject.Service;

import com.bp.todoitems.todoproject.Entity.Sql.TodoSqlEntity;
import com.bp.todoitems.todoproject.Entity.SqlAnalytics.TodoSqlAnalyticsEntity;
import com.bp.todoitems.todoproject.Repository.SqlAnalytics.TodoSqlAnalyticsRepository;
import com.bp.todoitems.todoproject.Repository.Sql.TodoSqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoItemsService {

    @Autowired
    private TodoSqlRepository todoSqlRepository;

    @Autowired
    private TodoSqlAnalyticsRepository todoSqlAnalyticsRepository;





        //add
    public void add(TodoSqlEntity todoSqlEntity, TodoSqlAnalyticsEntity todoSqlAnalyticsEntity) {
        todoSqlAnalyticsEntity.setUuid(UUID.randomUUID().toString());
        TodoSqlAnalyticsEntity todoItemAnalitycsSql = todoSqlAnalyticsEntity
                .builder()
                .uuid(todoSqlAnalyticsEntity.getUuid())
                .username(todoSqlAnalyticsEntity.getUsername())
                .title(todoSqlAnalyticsEntity.getTitle())
                .build();
        todoSqlAnalyticsRepository.save(todoItemAnalitycsSql);
        todoSqlEntity.setUuid(UUID.randomUUID().toString());
        TodoSqlEntity todoItemSql = TodoSqlEntity
                .builder()
                .uuid(todoSqlEntity.getUuid())
                .username(todoSqlEntity.getUsername())
                .title(todoSqlEntity.getTitle())
                .build();
        todoSqlRepository.save(todoItemSql);



    }
    //find
   public List<TodoSqlEntity> get(){
        return todoSqlRepository.findAll();

   }

   //update
    public TodoSqlEntity updateTodo(TodoSqlEntity todoSqlEntity){
        TodoSqlEntity zmiana = todoSqlRepository.findById(todoSqlEntity.getId()).orElse(null);
        //TodoSqlEntity zmiana1 = todoSqlAnalyticsRepository.findById(todoSqlEntity.getId()).orElse(null);
        zmiana.setUsername(todoSqlEntity.getUsername());
        zmiana.setTitle(todoSqlEntity.getTitle());
        return todoSqlRepository.save(zmiana);
    }
    //DELETE
    public void deleteTodoItems(Integer id){
        todoSqlRepository.deleteById(id);}
       // todoSqlAnalyticsRepository.deleteById(id);}
    }


