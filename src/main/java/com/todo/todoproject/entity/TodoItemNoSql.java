package com.todo.todoproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;


@Document(collection = "todo_items")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoItemNoSql {

    @Id
    private Integer id;

    private String uuid;
    private String username;
    private String password;
}
