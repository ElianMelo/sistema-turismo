/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que implementa o Passeio
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.PasseioDao;
import dominio.Passeio;

public class PasseioDaoImpl implements PasseioDao {

	// Instancia um EntityManager localmente
	private EntityManager em;
	
	// Torna o EntityManager local, um espelho do EntityManager da Thread
	public PasseioDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	// O EntityManager passa a observar o Passeio x e então insere ou atualiza ele
	@Override
	public void inserirAtualizar(Passeio x) {
		if(x.getCodPasseio() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	// O EntityManager  passa a observar o Passeio x e então o excluir
	@Override
	public void excluir(Passeio x) {
		x = em.merge(x);
		em.remove(x);
	}

	// Realiza uma busca no banco de dados e retorna o valor desejado
	@SuppressWarnings("unchecked")
	@Override
	public Passeio buscar(int cod) {
		// Cria uma string que consiste na consulta feita ao banco de dados
		String jpql = "SELECT x FROM Passeio x WHERE x.codPasseio = :p1";
		// Gera uma consulta que será feita ao banco de dados
		Query query = em.createQuery(jpql);
		// Seta parâmetros informados na string da consulta ex: :p1
		query.setParameter("p1", cod);
		// Captura os dados da pesquisa feita no banco de dados
		List<Passeio> aux = query.getResultList();
		// Retorna o primeiro item, se este houver
		return (aux.size() > 0) ? aux.get(0) : null;
	}

	// Realiza uma busca por todos os clientes
	@SuppressWarnings("unchecked")
	@Override
	public List<Passeio> buscarTodos() {
		// Cria uma string que consiste na consulta feita ao banco de dados 
		String jpql = "SELECT x FROM Passeio x";
		// Gera uma consulta que será feita ao banco de dados
		Query query = em.createQuery(jpql);
		// Captura os dados da pesquisa feita no banco de dados
		return query.getResultList();
	}

}
