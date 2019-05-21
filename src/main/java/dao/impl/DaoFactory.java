/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que instancia implementa��es
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
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
