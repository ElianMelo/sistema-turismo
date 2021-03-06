/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que implementa o Cliente
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
*/
package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ClienteDao;
import dominio.Cliente;

public class ClienteDaoImpl implements ClienteDao {
	
	// Instancia um EntityManager localmente
	private EntityManager em;
	
	// Torna o EntityManager local, um espelho do EntityManager da Thread
	public ClienteDaoImpl() {
		this.em = EM.getLocalEm();
	}

	// O EntityManager passa a observar o Cliente x e ent�o insere ou atualiza ele
	@Override
	public void inserirAtualizar(Cliente x) {
		if(x.getCodCliente() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	// O EntityManager  passa a observar o Cliente x e ent�o o excluir
	@Override
	public void excluir(Cliente x) {
		x = em.merge(x);
		em.remove(x);
	}

	// Realiza uma busca no banco de dados e retorna o valor desejado
	@SuppressWarnings("unchecked")
	@Override
	public Cliente buscar(int cod) {
		// Cria uma string que consiste na consulta feita ao banco de dados
		String jpql = "SELECT x FROM Cliente x WHERE x.codCliente = :p1";
		// Gera uma consulta que ser� feita ao banco de dados
		Query query = em.createQuery(jpql);
		// Seta par�metros informados na string da consulta ex: :p1
		query.setParameter("p1", cod);
		// Captura os dados da pesquisa feita no banco de dados
		List<Cliente> aux = query.getResultList();
		// Retorna o primeiro item, se este houver
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	
	// Realiza uma busca por todos os clientes
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarTodos() {
		// Cria uma string que consiste na consulta feita ao banco de dados 
		String jpql = "SELECT x FROM Cliente x";
		// Gera uma consulta que ser� feita ao banco de dados
		Query query = em.createQuery(jpql);
		// Captura os dados da pesquisa feita no banco de dados
		return query.getResultList();
	}

	// Realiza uma busca por todos os clientes, ordenando por nome
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarTodosOrdenadosPorNome() {
		// Cria uma string que consiste na consulta feita ao banco de dados 
		String jpql = "SELECT x FROM Cliente x ORDER BY x.nome";
		// Gera uma consulta que ser� feita ao banco de dados
		Query query = em.createQuery(jpql);
		// Captura os dados da pesquisa feita no banco de dados
		return query.getResultList();
	}

}
