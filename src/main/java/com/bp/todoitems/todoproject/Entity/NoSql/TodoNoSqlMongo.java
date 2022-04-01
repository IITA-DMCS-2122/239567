package com.bp.todoitems.todoproject.Entity.NoSql;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;


import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Document(collation = "todo_itmes")
public class TodoNoSqlMongo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String uuid;
    private String username;
    private String title;

    public TodoNoSqlMongo(){
        uuid = UUID.randomUUID().toString();
    }



}