/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 21/05/2019
Resumo: Classe DAO(Data Access Object) que funciona como um contrato com o Passeio
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
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
