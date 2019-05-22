/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 22/05/2019
Resumo: Classe Service que realiza opera��es com Contrato
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
*/
package servico;

import java.util.List;

import dao.ContratoDao;
import dao.impl.DaoFactory;
import dao.impl.Transaction;
import dominio.Contrato;

public class ContratoServico {

	// Cria um DAO de Contrato
	private ContratoDao dao;

	// Quando iniciado recebe a implementa��o
	public ContratoServico() {
		this.dao = DaoFactory.criarContratoDao();
	}

	// Realiza a opera��o de inser��o
	public void inserir(Contrato x) {
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
	public void atualizar(Contrato x) {
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
	public void excluir(Contrato x) {
		Transaction.begin();
		dao.excluir(x);
		Transaction.commit();
	}

	// Busca um Contrato no banco de dados
	public Contrato buscar(int cod) {
		return dao.buscar(cod);
	}

	// Busca todos os Contratos no banco de dados
	public List<Contrato> buscarTodos() {
		return dao.buscarTodos();
	}
}
