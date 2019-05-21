/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que gera EntityManager a partir da Factory
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dao.impl;

import javax.persistence.EntityManager;

public class EM {
	// Instancia uma Thread com EntityManager
	private static ThreadLocal<EntityManager> localEm = new ThreadLocal<EntityManager>();
	
	// Resgata ou Gera uma nova Thread com sua execução
	public static synchronized EntityManager getLocalEm() {
		EntityManager em = localEm.get();
		if(em == null) {
			em = EMF.get().createEntityManager();
			localEm.set(em);
		}
		return em;
	}
	
	// Finaliza o ciclo de vida de uma thread
	public static void closeLocalEm() {
		EntityManager em = localEm.get();
		if(em != null) {
			localEm.get().close();
			localEm.set(null);
		}
	}
}
