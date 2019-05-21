/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que funciona como um contrato com o Contrato
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dao;

import java.util.List;

import dominio.Contrato;

public interface ContratoDao {
	public void inserirAtualizar(Contrato x);
	public void excluir(Contrato x);
	public Contrato buscar(int cod);
	public List<Contrato> buscarTodos();
}
