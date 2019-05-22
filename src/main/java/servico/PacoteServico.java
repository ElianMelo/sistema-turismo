/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 22/05/2019
Resumo: Classe Service que realiza operações com Pacote
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package servico;

import java.util.List;

import dao.PacoteDao;
import dao.impl.DaoFactory;
import dao.impl.Transaction;
import dominio.Pacote;

public class PacoteServico {

	// Cria um DAO de Pacote
	private PacoteDao dao;

	// Quando iniciado recebe a implementação
	public PacoteServico() {
		this.dao = DaoFactory.criarPacoteDao();
	}

	// Realiza a operação de inserção
	public void inserir(Pacote x) {
		// Tentar inserir no banco de dados
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
			// Caso aconteça um erro
		} catch (RuntimeException e) {
			// E a transação estiver ativa
			if (Transaction.isActive()) {
				// Cancela a transação
				Transaction.rollback();
			}
			// E mostra o erro na tela
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// Realiza a operação de atualização
	public void atualizar(Pacote x) {
		// Tentar inserir no banco de dados
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
			// Caso aconteça um erro
		} catch (RuntimeException e) {
			// E a transação estiver ativa
			if (Transaction.isActive()) {
				// Cancela a transação
				Transaction.rollback();
			}
			// E mostra o erro na tela
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// Realiza a operação de exclusão
	public void excluir(Pacote x) {
		Transaction.begin();
		dao.excluir(x);
		Transaction.commit();
	}

	// Busca um Pacote no banco de dados
	public Pacote buscar(int cod) {
		return dao.buscar(cod);
	}

	// Busca todos os Pacotes no banco de dados
	public List<Pacote> buscarTodos() {
		return dao.buscarTodos();
	}
}
