/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 22/05/2019
Resumo: Classe Service que realiza operações com Cliente
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package servico;

import java.util.List;

import dao.ClienteDao;
import dao.impl.DaoFactory;
import dao.impl.Transaction;
import dominio.Cliente;

public class ClienteServico {
	
	// Cria um DAO de Cliente
	private ClienteDao dao;
	
	// Quando iniciado recebe a implementação
	public ClienteServico() {
		this.dao = DaoFactory.criarClienteDao();
	}
	
	// Realiza a operação de inserção ou atualização
	public void inserirAtualizar(Cliente x) {
		Transaction.begin();
		dao.inserirAtualizar(x);
		Transaction.commit();
	}
	
	// Realiza a operação de exclusão
	public void excluir(Cliente x) {
		Transaction.begin();
		dao.excluir(x);
		Transaction.commit();
	}
	
	// Busca um Cliente no banco de dados
	public Cliente buscar(int cod) {
		return dao.buscar(cod);
	}
	
	// Busca todos os Clientes no banco de dados
	public List<Cliente> buscarTodos(){
		return dao.buscarTodos();
	}
	
	// Realiza uma busca por todos os clientes, ordenando por nome
	public List<Cliente> buscarTodosOrdenadosPorNome() {
		return dao.buscarTodosOrdenadosPorNome();
	}
	
}
