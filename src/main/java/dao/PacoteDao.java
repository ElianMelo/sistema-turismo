/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que funciona como um contrato com o Pacote
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dao;

import java.util.List;

import dominio.Pacote;

public interface PacoteDao {
	public void inserirAtualizar(Pacote x);
	public void excluir(Pacote x);
	public Pacote buscar(int cod);
	public List<Pacote> buscarTodos();
}
