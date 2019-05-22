/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 22/05/2019
Resumo: Classe Service que realiza operações com Contrato
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
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

	// Quando iniciado recebe a implementação
	public ContratoServico() {
		this.dao = DaoFactory.criarContratoDao();
	}

	// Realiza a operação de inserção
	public void inserir(Contrato x) {
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
	public void atualizar(Contrato x) {
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
