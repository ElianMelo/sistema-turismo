/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 22/05/2019
Resumo: Classe Service que realiza operações com Passeio
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
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

	// Quando iniciado recebe a implementação
	public PasseioServico() {
		this.dao = DaoFactory.criarPasseioDao();
	}

	// Realiza a operação de inserção
	public void inserir(Passeio x) {
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
	public void atualizar(Passeio x) {
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
