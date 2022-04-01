package com.bp.todoitems.todoproject.Service;


import com.bp.todoitems.todoproject.Entity.NoSql.TodoNoSqlMongo;
import com.bp.todoitems.todoproject.Entity.Sql.TodoSqlEntity;
import com.bp.todoitems.todoproject.Repository.TodoMongoRepository;
import com.bp.todoitems.todoproject.Repository.TodoSqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TodoItemsMongoService {

    @Autowired
    private TodoMongoRepository todoMongoRepository;


    //add
    public void addmongo(TodoNoSqlMongo todoNoSqlMongo) {
        todoNoSqlMongo.setUuid(UUID.randomUUID().toString());
        TodoNoSqlMongo todoItemNoSql = TodoNoSqlMongo
                .builder()
                .uuid(todoNoSqlMongo.getUuid())
                .username(todoNoSqlMongo.getUsername())
                .title(todoNoSqlMongo.getTitle())
                .build();
        todoMongoRepository.save(todoItemNoSql);

    }
    //find
    public List<TodoNoSqlMongo> getmongo(){
        return todoMongoRepository.findAll();
    }

    //update
    public TodoNoSqlMongo updatemongo(TodoNoSqlMongo todoNoSqlMongo){
        TodoNoSqlMongo zmiana1 = todoMongoRepository.findById(todoNoSqlMongo.getId()).orElse(null);
        zmiana1.setUsername(todoNoSqlMongo.getUsername());
        zmiana1.setTitle(todoNoSqlMongo.getTitle());
        return todoMongoRepository.save(zmiana1);
    }
    //DELETE
    public void deletemongo(Integer id){
        todoMongoRepository.deleteById(id);
    }
}
