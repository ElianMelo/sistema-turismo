/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que gera EntityManagerFactory
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dao.impl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	// Instancia um EntityManagerFactory que produz EntityManager
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema.turismo");
	
	// Resgata o EntityManagerFactory
	public static EntityManagerFactory get() {
		return emf;
	}
}
