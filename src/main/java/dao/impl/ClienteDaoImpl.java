/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que implementa o Cliente
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ClienteDao;
import dominio.Cliente;

public class ClienteDaoImpl implements ClienteDao {
	
	private EntityManager em;
	
	public ClienteDaoImpl() {
		this.em = EM.getLocalEm();
	}

	@Override
	public void inserirAtualizar(Cliente x) {
		if(x.getCodCliente() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Cliente x) {
		x = em.merge(x);
		em.remove(x);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cliente buscar(int cod) {
		String jpql = "SELECT x FROM Cliente x WHERE x.codCliente = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", cod);
		List<Cliente> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarTodos() {
		String jpql = "SELECT x FROM Cliente x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarTodosOrdenadosPorNome() {
		String jpql = "SELECT x FROM Cliente x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}
