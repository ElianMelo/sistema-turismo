/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que funciona como um contrato com o Passeio
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dao;

import java.util.List;

import dominio.Passeio;

public interface PasseioDao {
	public void inserirAtualizar(Passeio x);
	public void excluir(Passeio x);
	public Passeio buscar(int cod);
	public List<Passeio> buscarTodos();
}
