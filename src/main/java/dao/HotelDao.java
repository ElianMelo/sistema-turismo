/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 16/05/2019
Resumo: Classe DAO(Data Access Object) que funciona como um contrato com o Hotel
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dao;

import java.math.BigDecimal;
import java.util.List;

import dominio.Hotel;

public interface HotelDao {
	public List<Hotel> buscaHoteis(String nome, BigDecimal precoMin, BigDecimal precoMax);
	public Hotel buscar(int cod);
}
