/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 22/05/2019
Resumo: Classe DAO(Data Access Object) que realiza métodos de transação
Referência ao enunciado/origem do exercício: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
*/

package dao.impl;

public class Transaction {

	// Inicia uma transação
	public static void begin() {
		EM.getLocalEm().getTransaction().begin();
	}
	
	// Finaliza uma transação
	public static void commit() {
		EM.getLocalEm().getTransaction().commit();
	}
	
	// Cancela a transação
	public static void rollback() {
		EM.getLocalEm().getTransaction().rollback();
	}
	
	// Verifica se a transação está ativa
	public static boolean isActive() {
		return EM.getLocalEm().getTransaction().isActive();
	}
}
