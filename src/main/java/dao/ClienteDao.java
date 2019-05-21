/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 16/05/2019
Resumo: Classe DAO(Data Access Object) que funciona como um contrato com o Cliente
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dao;

import java.util.List;

import dominio.Cliente;

public interface ClienteDao {
	public void inserirAtualizar(Cliente x);
	public void excluir(Cliente x);
	public Cliente buscar(int cod);
	public List<Cliente> buscarTodos();
	public List<Cliente> buscarTodosOrdenadosPorNome();
}
