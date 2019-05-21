/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que implementa o Contrato
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
*/
package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.ContratoDao;
import dominio.Contrato;

public class ContratoDaoImpl implements ContratoDao {

	// Instancia um EntityManager localmente
	private EntityManager em;
	
	// Torna o EntityManager local, um espelho do EntityManager da Thread
	public ContratoDaoImpl() {
		this.em = EM.getLocalEm();
	}
	
	// O EntityManager passa a observar o Contrato x e ent�o insere ou atualiza ele
	@Override
	public void inserirAtualizar(Contrato x) {
		if(x.getCodContrato() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	// O EntityManager  passa a observar o Contrato x e ent�o o excluir
	@Override
	public void excluir(Contrato x) {
		x = em.merge(x);
		em.remove(x);
	}

	// Realiza uma busca no banco de dados e retorna o valor desejado
	@SuppressWarnings("unchecked")
	@Override
	public Contrato buscar(int cod) {
		// Cria uma string que consiste na consulta feita ao banco de dados
		String jpql = "SELECT x FROM Contrato x WHERE x.codContrato = :p1";
		// Gera uma consulta que ser� feita ao banco de dados
		Query query = em.createQuery(jpql);
		// Seta par�metros informados na string da consulta ex: :p1
		query.setParameter("p1", cod);
		// Captura os dados da pesquisa feita no banco de dados
		List<Contrato> aux = query.getResultList();
		// Retorna o primeiro item, se este houver
		return (aux.size() > 0) ? aux.get(0) : null;
	}

	// Realiza uma busca por todos os clientes
	@SuppressWarnings("unchecked")
	@Override
	public List<Contrato> buscarTodos() {
		// Cria uma string que consiste na consulta feita ao banco de dados 
		String jpql = "SELECT x FROM Contrato x";
		// Gera uma consulta que ser� feita ao banco de dados
		Query query = em.createQuery(jpql);
		// Captura os dados da pesquisa feita no banco de dados
		return query.getResultList();
	}

}
