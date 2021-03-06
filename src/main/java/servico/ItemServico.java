/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 22/05/2019
Resumo: Classe Service que realiza opera��es com Item
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
*/
package servico;

import java.util.List;

import dao.ItemDao;
import dao.impl.DaoFactory;
import dao.impl.Transaction;
import dominio.Item;

public class ItemServico {

	// Cria um DAO de Item
	private ItemDao dao;

	// Quando iniciado recebe a implementa��o
	public ItemServico() {
		this.dao = DaoFactory.criarItemDao();
	}

	// Realiza a opera��o de inser��o
	public void inserir(Item x) {
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
	public void atualizar(Item x) {
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
	public void excluir(Item x) {
		Transaction.begin();
		dao.excluir(x);
		Transaction.commit();
	}

	// Busca um Item no banco de dados
	public Item buscar(int cod) {
		return dao.buscar(cod);
	}

	// Busca todos os Itens no banco de dados
	public List<Item> buscarTodos() {
		return dao.buscarTodos();
	}
}
