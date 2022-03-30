package com.bp.todoitems.todoproject;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TodoItmesController {

    private final TodoItemsService todoItemsService;

    @DeleteMapping("/delete/{id}")
    public void deleteTodoItmes(@PathVariable Integer id){
        todoItemsService.deleteTodoItems(id);
    }

    @GetMapping("/get/all")
    public List<TodoSqlEntity> getAll(){
        return todoItemsService.get();
    }

    @PostMapping("/add")
    public void add(@RequestBody TodoSqlEntity todoSqlEntity){
        todoItemsService.add(todoSqlEntity);
    }
    @PutMapping("/update")
    public void updateTodo(@RequestBody TodoSqlEntity todoSqlEntity){
        todoItemsService.updateTodo(todoSqlEntity);
    }
}
