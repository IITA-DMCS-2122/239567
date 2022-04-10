package com.bp.todoitems.todoproject.Controller;

import com.bp.todoitems.todoproject.Entity.NoSql.TodoNoSqlMongo;
import com.bp.todoitems.todoproject.Entity.Sql.TodoSqlEntity;
import com.bp.todoitems.todoproject.Entity.SqlAnalytics.TodoSqlAnalyticsEntity;
import com.bp.todoitems.todoproject.Service.TodoItemsMongoService;
import com.bp.todoitems.todoproject.Service.TodoItemsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TodoItmesController {

    private final TodoItemsService todoItemsService;
    private final TodoItemsMongoService todoItemsMongoService;

    @DeleteMapping("/delete/{id}")
    public void deleteTodoItmes(@PathVariable Integer id){
        todoItemsService.deleteTodoItems(id);
    }

    @GetMapping("/get/all")
    public List<TodoSqlEntity> getAll(){
        return todoItemsService.get();
    }

    @PostMapping("/add")
    public void add(@RequestBody TodoSqlEntity todoSqlEntity, TodoSqlAnalyticsEntity todoSqlAnalyticsEntity){
        todoItemsService.add(todoSqlEntity, todoSqlAnalyticsEntity);
    }

    @PutMapping("/update")
    public void updateTodo(@RequestBody TodoSqlEntity todoSqlEntity){
        todoItemsService.updateTodo(todoSqlEntity);
    }

    @PostMapping("/addmongo")
    public void addmongo(@RequestBody TodoNoSqlMongo todoNoSqlMongo){ todoItemsMongoService.addmongo(todoNoSqlMongo);}

    @GetMapping("/getmongo")
    public List<TodoNoSqlMongo> getAllmongo(){return todoItemsMongoService.getmongo();}

    @DeleteMapping("/deletemonogo/{id}")
    public void deletemongo(@PathVariable Integer id) { todoItemsMongoService.deletemongo(id);}

    @PutMapping("/updatemongo")
    public void updateemongo(@RequestBody TodoNoSqlMongo todoNoSqlMongo){ todoItemsMongoService.updatemongo(todoNoSqlMongo);}
}
