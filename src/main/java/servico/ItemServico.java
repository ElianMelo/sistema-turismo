/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 22/05/2019
Resumo: Classe Service que realiza operações com Item
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package servico;

import java.util.List;

import dao.ItemDao;
import dao.impl.DaoFactory;
import dao.impl.Transaction;
import dominio.Item;

public class ItemServico {
	
	// Cria um DAO de Item
	private ItemDao dao;
	
	// Quando iniciado recebe a implementação
	public ItemServico() {
		this.dao = DaoFactory.criarItemDao();
	}
	
	// Realiza a operação de inserção ou atualização
	public void inserirAtualizar(Item x) {
		Transaction.begin();
		dao.inserirAtualizar(x);
		Transaction.commit();
	}
	
	// Realiza a operação de exclusão
	public void excluir(Item x) {
		Transaction.begin();
		dao.excluir(x);
		Transaction.commit();
	}
	
	// Busca um Item no banco de dados
	public Item buscar(int cod) {
		return dao.buscar(cod);
	}
	
	// Busca todos os Itens no banco de dados
	public List<Item> buscarTodos(){
		return dao.buscarTodos();
	}
}
