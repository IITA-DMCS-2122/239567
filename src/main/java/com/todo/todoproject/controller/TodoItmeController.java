package com.todo.todoproject.controller;


import com.todo.todoproject.entity.TodoItemFromUser;
import com.todo.todoproject.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TodoItmeController {

    private final TodoService todoService;

    @GetMapping("/get/{uuid}")
    public TodoItemFromUser getItem(@PathVariable String uuid) {
        return todoService.getByUuid(uuid);
    }

    @GetMapping("/get/all")
    public List<TodoItemFromUser> getAllItems() {
        return todoService.getAll();
    }

    @PostMapping("/add")
    public void addItem(@RequestBody TodoItemFromUser todoItem) {
        todoService.add(todoItem);
    }

    @DeleteMapping("/delete/{uuid}")
    public void deleteItem(@PathVariable String uuid) {
        todoService.deleteByUuid(uuid);
    }

    @PutMapping("/update")
    public void updateItem(@RequestBody TodoItemFromUser todoItem) {
        todoService.update(todoItem);
    }

    @GetMapping("/search/{title}")
    public List<TodoItemFromUser> searchItemsElastic(@PathVariable String title) {
        return todoService.search(title);
    }

}
