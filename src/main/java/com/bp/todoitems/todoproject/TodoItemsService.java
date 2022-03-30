package com.bp.todoitems.todoproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TodoItemsService {

    @Autowired
    private TodoSqlRepository todoSqlRepository;

    //add
    public void add(TodoSqlEntity todoSqlEntity) {
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
        zmiana.setUsername(todoSqlEntity.getUsername());
        zmiana.setTitle(todoSqlEntity.getTitle());
        return todoSqlRepository.save(zmiana);
    }
    //DELETE
    public void deleteTodoItems(Integer id){
        todoSqlRepository.deleteById(id);
    }
}
