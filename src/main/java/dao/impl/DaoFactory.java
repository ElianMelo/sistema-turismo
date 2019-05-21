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
	
	public static ClienteDao criarClienteDao() {
		return new ClienteDaoImpl();
	}
	
	public static ContratoDao criarContratoDao() {
		return new ContratoDaoImpl();
	}
	
	public static HotelDao criarHotelDao() {
		return new HotelDaoImpl();
	}
	
	public static ItemDao criarItemDao() {
		return new ItemDaoImpl();
	}
	
	public static PacoteDao criarPacoteDao() {
		return new PacoteDaoImpl();
	}
	
	public static PasseioDao criarPasseioDao() {
		return new PasseioDaoImpl();
	}
	
}
