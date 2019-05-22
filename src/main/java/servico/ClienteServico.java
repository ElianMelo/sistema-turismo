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
	
	// Realiza a operação de inserção
	public void inserir(Cliente x) {
		// Tentar inserir no banco de dados
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		// Caso aconteça um erro
		} catch(RuntimeException e) {
			// E a transação estiver ativa
			if(Transaction.isActive()){
				// Cancela a transação
				Transaction.rollback();
			}
			// E mostra o erro na tela
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	// Realiza a operação de atualização
	public void atualizar(Cliente x) {
		// Tentar inserir no banco de dados
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
		// Caso aconteça um erro
		} catch(RuntimeException e) {
			// E a transação estiver ativa
			if(Transaction.isActive()){
				// Cancela a transação
				Transaction.rollback();
			}
			// E mostra o erro na tela
			System.out.println("Erro: " + e.getMessage());
		}
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
