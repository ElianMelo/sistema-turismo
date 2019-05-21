/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que implementa o Hotel
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.HotelDao;
import dominio.Hotel;

public class HotelDaoImpl implements HotelDao {
	
	// Instancia um EntityManager localmente
	private EntityManager em;
	
	// Torna o EntityManager local, um espelho do EntityManager da Thread
	public HotelDaoImpl() {
		this.em = EM.getLocalEm();
	}

	// O EntityManager passa a observar o Cliente x e então insere ou atualiza ele
	@Override
	public void inserirAtualizar(Hotel x) {
		if(x.getCodHotel() != null) {
			em.merge(x);
		}
		em.persist(x);
	}

	// O EntityManager  passa a observar o Cliente x e então o excluir
	@Override
	public void excluir(Hotel x) {
		x = em.merge(x);
		em.persist(x);
	}

	// Realiza uma busca no banco de dados e retorna o valor desejado
	@SuppressWarnings("unchecked")
	@Override
	public Hotel buscar(int cod) {
		// Cria uma string que consiste na consulta feita ao banco de dados
		String jpql = "SELECT x FROM Hotel x WHERE codHotel = :p1";
		// Gera uma consulta que será feita ao banco de dados
		Query query = em.createQuery(jpql);
		// Seta parâmetros informados na string da consulta ex: :p1
		query.setParameter("p1", cod);
		// Captura os dados da pesquisa feita no banco de dados
		List<Hotel> aux = query.getResultList();
		// Retorna o primeiro item, se este houver
		return (aux.size() > 0) ? aux.get(0) : null;
	}

	// Realiza uma busca por todos os hoteis
	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> buscarTodos() {
		// Cria uma string que consiste na consulta feita ao banco de dados 
		String jpql = "SELECT x FROM Hotel x";
		// Gera uma consulta que será feita ao banco de dados
		Query query = em.createQuery(jpql);
		// Captura os dados da pesquisa feita no banco de dados
		return query.getResultList();
	}

	// Realiza uma busca especifica entre os hoteis
	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> buscaHoteis(String nome, BigDecimal precoMin, BigDecimal precoMax) {
		// Cria uma string que consiste na consulta feita ao banco de dados 
		String jpql = "SELECT x FROM Hotel x WHERE x.nome LIKE :p1 AND x.diaria BETWEEN :p2 AND :p3";
		// Gera uma consulta que será feita ao banco de dados
		Query query = em.createQuery(jpql);
		// Define o parâmetro :p1
		query.setParameter("p1", "%" + nome + "%");
		// Define o parâmetro :p2
		query.setParameter("p2", precoMin);
		// Define o parâmetro :p3
		query.setParameter("p3", precoMax);
		// Captura os dados da pesquisa feita no banco de dados
		return query.getResultList();
	}

}
