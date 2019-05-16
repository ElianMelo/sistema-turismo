/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 14/05/2019
Resumo: Classe que representa um pacote com itens e um hotel oferecidos a um cliente
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pacote")
public class Pacote implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codPacote;
	private String nome;
	private Integer diarias;
	
	@OneToMany(mappedBy="pacote")
	private List<Contrato> contratos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="hotel")
	private Hotel hotel;
	
	@OneToMany(mappedBy="pacote")
	private List<Item> itens = new ArrayList<>();
	
	public Pacote() {
		
	}

	public Pacote(Integer codPacote, String nome, Integer diarias, Hotel hotel) {
		super();
		this.codPacote = codPacote;
		this.nome = nome;
		this.diarias = diarias;
		this.hotel = hotel;
		hotel.addPacote(this);
	}

	public Integer getCodPacote() {
		return codPacote;
	}

	public void setCodPacote(Integer codPacote) {
		this.codPacote = codPacote;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDiarias() {
		return diarias;
	}

	public void setDiarias(Integer diarias) {
		this.diarias = diarias;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	
	public void addContrato(Contrato x) {
		this.contratos.add(x);
		x.setPacote(this);
	}
	
	public void removeContrato(Contrato x) {
		this.contratos.remove(x);
	}
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public void addItem(Item x) {
		this.itens.add(x);
		x.setPacote(this);
	}
	
	public void removeItem(Item x) {
		this.itens.remove(x);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPacote == null) ? 0 : codPacote.hashCode());
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
		Pacote other = (Pacote) obj;
		if (codPacote == null) {
			if (other.codPacote != null)
				return false;
		} else if (!codPacote.equals(other.codPacote))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pacote [codPacote=" + codPacote + ", nome=" + nome + ", diarias=" + diarias + "]";
	}
	
	// Método que calcula o preço total de todos os passeios
	public BigDecimal precoPasseios() {
		BigDecimal resultado = new BigDecimal("0.00");
		for(Item item : itens) {
			resultado = resultado.add(item.getPasseio().getPreco());
		}
		return resultado;
	}
	
	// Método que calcula o preço total do pacote (incluindo os passeios)
	public BigDecimal precoTotal() {
		BigDecimal resultado = new BigDecimal("0.00");
		resultado = resultado.add(precoPasseios());
		BigDecimal diarias = new BigDecimal(this.diarias);
		resultado = resultado.add(diarias.multiply(hotel.getDiaria()));
		return resultado;
	}
}
