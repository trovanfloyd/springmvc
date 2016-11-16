package br.com.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.spring.dao.JdbcTarefaDao;
import br.com.spring.model.Tarefa;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/helloWorld")
	public String execute(ModelMap model) {
		System.out.println("Ola mundo Spring MVC");
		model.addAttribute("message", "Spring MVC working");
		return "ok";
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getData() {
		List<String> list = getList();
		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", list);
		return model;
	}*/
	
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ModelAndView getData() {
		List<String> list = getList();
		ModelAndView model = new ModelAndView("index");
		model.addObject("lists", list);
		return model;
	}
	
	private List<String> getList() {
		 
		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");
 
		return list;
 
	}
	
	@RequestMapping("adicionaTarefa2")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/lista";
	}

}
