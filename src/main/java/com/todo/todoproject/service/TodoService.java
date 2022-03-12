package com.todo.todoproject.service;

import com.todo.todoproject.entity.TodoEntity;
import com.todo.todoproject.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;

@Service
public class TodoService {

    @Autowired
    private TodoRepository userRepository;
    public TodoEntity getUser(TodoEntity user) {
        System.out.println("Service GET *****");
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
    public boolean getUserByUsername(String username, String password) {
        boolean username_present;
        boolean password_present;
        try {
            username_present = userRepository.findTopByUsername(username) != null ? true : false;
            System.out.println("Username present: " + username_present);
            password_present = userRepository.findTopByPassword(password) != null ? true : false;
            System.out.println("Password present: " + password_present);
        } catch(NonUniqueResultException nre) {
            return true;
        }
        return username_present && password_present;
    }

    public boolean findUserByUsername(String username) {
        boolean username_present;
        try {
            username_present = userRepository.findTopByUsername(username) != null ? true : false;
            System.out.println("Username present (U): " + username_present);
        } catch(NonUniqueResultException nre) {
            return true;
        }
        return username_present;
    }

    public void saveUser(TodoEntity user) {
        userRepository.save(user);
    }
}
