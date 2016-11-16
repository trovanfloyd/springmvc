package br.com.spring.controller;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.spring.dao.JdbcTarefaDao;
import br.com.spring.model.Tarefa;

@Controller
public class TarefaController {
	
	public List<Tarefa> tarefas;

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("/")
	public String init() {
		return "tarefa/formulario";
	}
	
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		tarefas = getListTarefas();
		
		model.addAttribute("tarefas", tarefas);
		return "tarefa/lista";
	}
	
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		tarefas.remove(tarefa);
		return "forward:listaTarefas";
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		
		model.addAttribute("tarefa", getTarefa1());
		return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa taefa) {
		
		return "forward:listaTarefas";
	}
	
	private List<Tarefa> getListTarefas() {
		 
		List<Tarefa> list = new ArrayList<Tarefa>();
		
		Tarefa t1 = new Tarefa();
		t1.setId(1L);
		t1.setDescricao("Tarefa 1");
		t1.setDataFinalizacao(new GregorianCalendar());
		t1.setFinalizado(false);
		
		Tarefa t2 = new Tarefa();
		t2.setId(2L);
		t2.setDescricao("Tarefa 2");
		t2.setDataFinalizacao(new GregorianCalendar());
		t2.setFinalizado(false);
		
		Tarefa t3 = new Tarefa();
		t3.setId(3L);
		t3.setDescricao("Tarefa 3");
		t3.setDataFinalizacao(new GregorianCalendar());
		t3.setFinalizado(false);
		
		list.add(t1);
		list.add(t2);
		list.add(t3);
 
		return list;
 
	}
	
	public Tarefa getTarefa1() {
		Tarefa t1 = new Tarefa();
		t1.setId(1L);
		t1.setDescricao("Tarefa 1");
		t1.setDataFinalizacao(new GregorianCalendar());
		t1.setFinalizado(false);
		return t1;
	}
	
	@RequestMapping("finalizaTarefa")
	public void finaliza(Long id, HttpServletResponse response) {
	  JdbcTarefaDao dao = new JdbcTarefaDao();
	  //dao.finaliza(id);
	  response.setStatus(200);
	}
	
}
