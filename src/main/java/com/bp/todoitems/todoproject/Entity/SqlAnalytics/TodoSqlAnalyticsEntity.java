package com.bp.todoitems.todoproject.Entity.SqlAnalytics;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todo_items2")
public class TodoSqlAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String uuid;

    @Column(name = "username", unique = true)
    private String username;
    private String title;


}
