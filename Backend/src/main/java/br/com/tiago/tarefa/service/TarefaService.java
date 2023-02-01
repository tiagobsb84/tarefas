package br.com.tiago.tarefa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tiago.tarefa.model.Tarefa;
import br.com.tiago.tarefa.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	public List<Tarefa> buscarTodos() {
		List<Tarefa> listaTodos = tarefaRepository.findAll();
		return listaTodos;
	}

	public Tarefa buscarPorId(Integer id) {
		Optional<Tarefa> findById = this.tarefaRepository.findById(id);
		return findById.orElse(null);
	}

	public List<Tarefa> buscarTodosClosed() {
		List<Tarefa> buscarPorClose = this.tarefaRepository.findAllClosed();
		return buscarPorClose;
	}

	public List<Tarefa> buscarTodosNaoClosed() {
		List<Tarefa> buscarPorNaoFinalizado = this.tarefaRepository.findAllNaoClosed();
		return buscarPorNaoFinalizado;
	}

	public void delete(Integer id) {
		this.tarefaRepository.deleteById(id);
	}

	public Tarefa create(Tarefa obj) {
		obj.setId(null);
		return tarefaRepository.save(obj);
	}

	
	
	
}