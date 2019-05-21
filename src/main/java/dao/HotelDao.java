/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 16/05/2019
Resumo: Classe DAO(Data Access Object) que funciona como um contrato com o Hotel
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
*/
package dao;

import java.math.BigDecimal;
import java.util.List;

import dominio.Hotel;

public interface HotelDao {
	public List<Hotel> buscaHoteis(String nome, BigDecimal precoMin, BigDecimal precoMax);
	public Hotel buscar(int cod);
}
