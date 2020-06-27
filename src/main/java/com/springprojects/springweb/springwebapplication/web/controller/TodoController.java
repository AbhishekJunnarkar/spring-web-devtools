package com.springprojects.springweb.springwebapplication.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springprojects.springweb.springwebapplication.web.service.TodoService;

//This is a controller
@Controller
@SessionAttributes("name")
public class TodoController {
	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/todo-list", method = RequestMethod.GET)
	public String showTodoList(ModelMap model) {
		model.put("todos", todoService.retrieveTodos((String) model.get("name")));
		return "/todo-list";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		return "/todo";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:/todo-list";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @RequestParam String desc) {
		todoService.addTodo((String)model.get("name"), desc, new Date(), false);
		model.put("todos", todoService.retrieveTodos((String) model.get("name")));
		return "/todo-list";//redirect:/todo-list
	}
}
