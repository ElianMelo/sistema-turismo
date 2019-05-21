/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que instancia implementações
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dao.impl;

import dao.ClienteDao;
import dao.HotelDao;

public class DaoFactory {
	public static ClienteDao criarClienteDao() {
		return new ClienteDaoImpl();
	}
	
	public static HotelDao criarHotelDao() {
		return new HotelDaoImpl();
	}
}
