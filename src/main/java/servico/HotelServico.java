/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 22/05/2019
Resumo: Classe Service que realiza operações com Hotel
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package servico;

import java.math.BigDecimal;
import java.util.List;

import dao.HotelDao;
import dao.impl.DaoFactory;
import dao.impl.Transaction;
import dominio.Hotel;

public class HotelServico {

	// Cria um DAO de Hotel
	private HotelDao dao;

	// Quando iniciado recebe a implementação
	public HotelServico() {
		this.dao = DaoFactory.criarHotelDao();
	}

	// Realiza a operação de inserção
	public void inserir(Hotel x) {
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
	public void atualizar(Hotel x) {
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
	public void excluir(Hotel x) {
		Transaction.begin();
		dao.excluir(x);
		Transaction.commit();
	}

	// Busca um Hotel no banco de dados
	public Hotel buscar(int cod) {
		return dao.buscar(cod);
	}

	// Busca todos os Hoteis no banco de dados
	public List<Hotel> buscarTodos() {
		return dao.buscarTodos();
	}

	// Busca um Hotel específico
	public List<Hotel> buscaHoteis(String nome, BigDecimal precoMin, BigDecimal precoMax) {
		return dao.buscaHoteis(nome, precoMin, precoMax);
	}

}
