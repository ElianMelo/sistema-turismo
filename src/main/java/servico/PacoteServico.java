/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 22/05/2019
Resumo: Classe Service que realiza opera��es com Pacote
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
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

	// Quando iniciado recebe a implementa��o
	public PacoteServico() {
		this.dao = DaoFactory.criarPacoteDao();
	}

	// Realiza a opera��o de inser��o
	public void inserir(Pacote x) {
		// Tentar inserir no banco de dados
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
			// Caso aconte�a um erro
		} catch (RuntimeException e) {
			// E a transa��o estiver ativa
			if (Transaction.isActive()) {
				// Cancela a transa��o
				Transaction.rollback();
			}
			// E mostra o erro na tela
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// Realiza a opera��o de atualiza��o
	public void atualizar(Pacote x) {
		// Tentar inserir no banco de dados
		try {
			Transaction.begin();
			dao.inserirAtualizar(x);
			Transaction.commit();
			// Caso aconte�a um erro
		} catch (RuntimeException e) {
			// E a transa��o estiver ativa
			if (Transaction.isActive()) {
				// Cancela a transa��o
				Transaction.rollback();
			}
			// E mostra o erro na tela
			System.out.println("Erro: " + e.getMessage());
		}
	}

	// Realiza a opera��o de exclus�o
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
