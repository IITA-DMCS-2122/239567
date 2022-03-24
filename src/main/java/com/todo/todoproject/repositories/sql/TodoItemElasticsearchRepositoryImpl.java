package com.todo.todoproject.repositories.sql;

import com.todo.todoproject.entity.TodoItemSql;
import com.todo.todoproject.repositories.sql.TodoItemElasticsearchRepository;
import org.hibernate.search.mapper.orm.Search;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TodoItemElasticsearchRepositoryImpl implements TodoItemElasticsearchRepository {
   @PersistenceContext
   private EntityManager entityManager;

    @Override
    public List<TodoItemSql> search(String query) {
        return Search.session(entityManager)
                .search(TodoItemSql.class)
                .where(f -> f.match()
                        .field("username")
                        .matching(query)
                        .fuzzy())
                .fetchAllHits();
    }
}
