/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 22/05/2019
Resumo: Classe Service que realiza opera��es com Passeio
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
*/
package servico;

import java.util.List;

import dao.PasseioDao;
import dao.impl.DaoFactory;
import dao.impl.Transaction;
import dominio.Passeio;

public class PasseioServico {

	// Cria um DAO de Passeio
	private PasseioDao dao;

	// Quando iniciado recebe a implementa��o
	public PasseioServico() {
		this.dao = DaoFactory.criarPasseioDao();
	}

	// Realiza a opera��o de inser��o
	public void inserir(Passeio x) {
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
	public void atualizar(Passeio x) {
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
	public void excluir(Passeio x) {
		Transaction.begin();
		dao.excluir(x);
		Transaction.commit();
	}

	// Busca um Passeio no banco de dados
	public Passeio buscar(int cod) {
		return dao.buscar(cod);
	}

	// Busca todos os Passeios no banco de dados
	public List<Passeio> buscarTodos() {
		return dao.buscarTodos();
	}
}
