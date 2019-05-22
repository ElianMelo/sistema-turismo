/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que instancia implementa��es
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
*/
package dao.impl;

import dao.ClienteDao;
import dao.ContratoDao;
import dao.HotelDao;
import dao.ItemDao;
import dao.PacoteDao;
import dao.PasseioDao;

public class DaoFactory {
	
	// Retorna a implementa��o do ClienteDao
	public static ClienteDao criarClienteDao() {
		return new ClienteDaoImpl();
	}
	
	// Retorna a implementa��o do ContratoDao
	public static ContratoDao criarContratoDao() {
		return new ContratoDaoImpl();
	}
	
	// Retorna a implementa��o do HotelDao
	public static HotelDao criarHotelDao() {
		return new HotelDaoImpl();
	}
	
	// Retorna a implementa��o do ItemDao
	public static ItemDao criarItemDao() {
		return new ItemDaoImpl();
	}
	
	// Retorna a implementa��o do PacoteDao
	public static PacoteDao criarPacoteDao() {
		return new PacoteDaoImpl();
	}
	
	// Retorna a implementa��o do PasseioDao
	public static PasseioDao criarPasseioDao() {
		return new PasseioDaoImpl();
	}
	
}
