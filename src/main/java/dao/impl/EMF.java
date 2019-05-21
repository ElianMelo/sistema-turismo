/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que gera EntityManagerFactory
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
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
