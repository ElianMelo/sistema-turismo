package dominio;

import java.io.Serializable;

public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer codItem;
	private Integer ordem;
	private Pacote pacote;
	
	public Item() {
		
	}
	
	public Item(Integer codItem, Integer ordem, Pacote pacote) {
		super();
		this.codItem = codItem;
		this.ordem = ordem;
		this.pacote = pacote;
		pacote.addItem(this);
	}

	public Integer getCodItem() {
		return codItem;
	}

	public void setCodItem(Integer codItem) {
		this.codItem = codItem;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codItem == null) ? 0 : codItem.hashCode());
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
		Item other = (Item) obj;
		if (codItem == null) {
			if (other.codItem != null)
				return false;
		} else if (!codItem.equals(other.codItem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [codItem=" + codItem + ", ordem=" + ordem + "]";
	}
}
