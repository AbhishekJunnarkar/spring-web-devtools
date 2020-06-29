package com.springprojects.springweb.springwebapplication.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springprojects.springweb.springwebapplication.web.model.Todo;
import com.springprojects.springweb.springwebapplication.web.service.TodoService;

//This is a controller
@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService todoService;

	// Date - dd/MM/yyyy
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/todo-list", method = RequestMethod.GET)
	public String showTodoList(ModelMap model) {
		model.put("todos", todoService.retrieveTodos((String) model.get("name")));
		return "/todo-list";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("todo", new Todo(0, (String) model.get("name"), "Default Desc", new Date(), false));
		return "/todo";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteTodo(id);
		return "redirect:/todo-list";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(ModelMap modelmap, @RequestParam int id) {
		Todo todo = todoService.retrieveTodo(id);
		modelmap.put("todo", todo);
		return "/todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "/todo";
		}
		todo.setUser((String) model.get("name"));
		todo.setTargetDate(todo.getTargetDate());
		todoService.updateTodo(todo);
		return "redirect:/todo-list";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "/todo";
		}
		todoService.addTodo((String) model.get("name"), todo.getDesc(), todo.getTargetDate(), false);
		model.put("todos", todoService.retrieveTodos((String) model.get("name")));
		return "/todo-list";// redirect:/todo-list
	}
}