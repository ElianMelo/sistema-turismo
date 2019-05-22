/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 22/05/2019
Resumo: Classe Service que realiza opera��es com Hotel
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
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

	// Quando iniciado recebe a implementa��o
	public HotelServico() {
		this.dao = DaoFactory.criarHotelDao();
	}

	// Realiza a opera��o de inser��o
	public void inserir(Hotel x) {
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
	public void atualizar(Hotel x) {
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

	// Busca um Hotel espec�fico
	public List<Hotel> buscaHoteis(String nome, BigDecimal precoMin, BigDecimal precoMax) {
		return dao.buscaHoteis(nome, precoMin, precoMax);
	}

}
