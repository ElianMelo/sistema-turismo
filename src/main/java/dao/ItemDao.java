/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que funciona como um contrato com o Item
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dao;

import java.util.List;

import dominio.Item;

public interface ItemDao {
	public void inserirAtualizar(Item x);
	public void excluir(Item x);
	public Item buscar(int cod);
	public List<Item> buscarTodos();
}
