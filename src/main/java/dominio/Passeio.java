/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 15/05/2019
Resumo: Classe que corresponde a um passeio que será fornecido ao cliente
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/
package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="passeio")
public class Passeio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codPasseio;
	private String nome;
	private BigDecimal preco;
	private String cidade;
	
	@OneToMany(mappedBy="passeio")
	private List<Item> itens = new ArrayList<>();
	
	public Passeio() {
		
	}

	public Passeio(Integer codPasseio, String nome, BigDecimal preco, String cidade) {
		super();
		this.codPasseio = codPasseio;
		this.nome = nome;
		this.preco = preco;
		this.cidade = cidade;
	}

	public Integer getCodPasseio() {
		return codPasseio;
	}

	public void setCodPasseio(Integer codPasseio) {
		this.codPasseio = codPasseio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public void addItem(Item x) {
		this.itens.add(x);
		x.setPasseio(this);
	}
	
	public void removeItem(Item x) {
		this.itens.remove(x);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPasseio == null) ? 0 : codPasseio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passeio other = (Passeio) obj;
		if (codPasseio == null) {
			if (other.codPasseio != null)
				return false;
		} else if (!codPasseio.equals(other.codPasseio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passeio [codPasseio=" + codPasseio + ", nome=" + nome + ", preco=" + preco + ", cidade=" + cidade + "]";
	}
}
