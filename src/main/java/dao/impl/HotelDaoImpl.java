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
	
	private EntityManager em;
	
	public HotelDaoImpl() {
		this.em = EM.getLocalEm();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> buscaHoteis(String nome, BigDecimal precoMin, BigDecimal precoMax) {
		String jpql = "SELECT x FROM Cliente x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Hotel buscar(int cod) {
		String jpql = "SELECT x FROM Hotel x WHERE x.nome = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", cod);
		List<Hotel> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}

}
