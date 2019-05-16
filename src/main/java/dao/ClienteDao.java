package dao;

import java.util.List;

import dominio.Cliente;

public interface ClienteDao {
	public void inserir(Cliente x);
	public void atualizar(Cliente x);
	public void excluir(Cliente x);
	public Cliente buscar(int cod);
	public List<Cliente> buscarTodos();
	public List<Cliente> buscarTodosOrdenadosPorNome();
}
