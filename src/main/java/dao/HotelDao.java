package dao;

import java.math.BigDecimal;
import java.util.List;

import dominio.Hotel;

public interface HotelDao {
	public List<Hotel> buscaHoteis(String nome, BigDecimal precoMin, BigDecimal precoMax);
	public Hotel buscar(int cod);
}
