/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que instancia implementações
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dao.impl;

import dao.ClienteDao;
import dao.ContratoDao;
import dao.HotelDao;
import dao.ItemDao;
import dao.PacoteDao;
import dao.PasseioDao;

public class DaoFactory {
	
	// Retorna a implementação do ClienteDao
	public static ClienteDao criarClienteDao() {
		return new ClienteDaoImpl();
	}
	
	// Retorna a implementação do ContratoDao
	public static ContratoDao criarContratoDao() {
		return new ContratoDaoImpl();
	}
	
	// Retorna a implementação do HotelDao
	public static HotelDao criarHotelDao() {
		return new HotelDaoImpl();
	}
	
	// Retorna a implementação do ItemDao
	public static ItemDao criarItemDao() {
		return new ItemDaoImpl();
	}
	
	// Retorna a implementação do PacoteDao
	public static PacoteDao criarPacoteDao() {
		return new PacoteDaoImpl();
	}
	
	// Retorna a implementação do PasseioDao
	public static PasseioDao criarPasseioDao() {
		return new PasseioDaoImpl();
	}
	
}
