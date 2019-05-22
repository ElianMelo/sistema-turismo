/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 22/05/2019
Resumo: Classe DAO(Data Access Object) que realiza m�todos de transa��o
Refer�ncia ao enunciado/origem do exerc�cio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
*/

package dao.impl;

public class Transaction {

	// Inicia uma transa��o
	public static void begin() {
		EM.getLocalEm().getTransaction().begin();
	}
	
	// Finaliza uma transa��o
	public static void commit() {
		EM.getLocalEm().getTransaction().commit();
	}
	
	// Cancela a transa��o
	public static void rollback() {
		EM.getLocalEm().getTransaction().rollback();
	}
	
	// Verifica se a transa��o est� ativa
	public static boolean isActive() {
		return EM.getLocalEm().getTransaction().isActive();
	}
}
