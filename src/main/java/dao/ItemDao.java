/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que funciona como um contrato com o Item
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
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
