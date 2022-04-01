package com.bp.todoitems.todoproject.Repository;

import com.bp.todoitems.todoproject.Entity.NoSql.TodoNoSqlMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoMongoRepository extends MongoRepository<TodoNoSqlMongo, Integer> {
    void deleteById(Integer id);


}
