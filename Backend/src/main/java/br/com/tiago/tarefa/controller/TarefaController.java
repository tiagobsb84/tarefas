package br.com.tiago.tarefa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiago.tarefa.model.Tarefa;
import br.com.tiago.tarefa.service.TarefaService;

@RestController
@RequestMapping(value = "/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;
	
	@GetMapping
	public ResponseEntity<List<Tarefa>> buscarTodos() {
		List<Tarefa> listaTodos = tarefaService.buscarTodos();
		return ResponseEntity.ok().body(listaTodos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tarefa> buscarPorId(@PathVariable Integer id){
		Tarefa buscaPorId = tarefaService.buscarPorId(id);
		return ResponseEntity.ok().body(buscaPorId);
	}
	
	@GetMapping(value = "/closed")
	public ResponseEntity<List<Tarefa>> buscarTodosFinalizados() {
		List<Tarefa> listaFinalizados = tarefaService.buscarTodosClosed();
		return ResponseEntity.ok().body(listaFinalizados);
	}
	
	@GetMapping(value = "/open")
	public ResponseEntity<List<Tarefa>> buscarTodosNaoFinalizados() {
		List<Tarefa> listaNaoFinalizados = tarefaService.buscarTodosNaoClosed();
		return ResponseEntity.ok().body(listaNaoFinalizados);
	}
}
