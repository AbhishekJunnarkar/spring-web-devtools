package com.springprojects.springweb.springwebapplication.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springprojects.springweb.springwebapplication.web.model.Todo;

@Service
public class TodoService {
	// static List of todos
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;
	// Initial TODO's
	static {
		todos.add(new Todo(1, "Abhishek", "Spring Boot", new Date(), false));
		todos.add(new Todo(2, "Abhishek", "Spring Batch", new Date(), false));
		todos.add(new Todo(3, "Abhishek", "Spring Cloud", new Date(), false));
	}

	/**
	 * Add A todo
	 * 
	 * @param name
	 * @param desc
	 * @param targetDate
	 * @param isDone
	 */
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}

	/**
	 * deleteTODO
	 * 
	 * @param id
	 */
	public void deleteTodo(int id) {
		Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}

	/**
	 * retrieve TODOs using userId
	 * 
	 * @param user
	 * @return
	 */
	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
}