/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 22/05/2019
Resumo: Classe Service que realiza opera��es com Cliente
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
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
	
	// Quando iniciado recebe a implementa��o
	public ClienteServico() {
		this.dao = DaoFactory.criarClienteDao();
	}
	
	// Realiza a opera��o de inser��o ou atualiza��o
	public void inserirAtualizar(Cliente x) {
		Transaction.begin();
		dao.inserirAtualizar(x);
		Transaction.commit();
	}
	
	// Realiza a opera��o de exclus�o
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
