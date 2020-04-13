package br.com.qintess.cerveja;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import br.com.qintess.venda.ItenVenda;



@Entity 
@Table(name = "cerveja")
public class Cerveja implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private double valor;
	
	@Column
	private double teor_alcoolico;
	
	@Column
	private String sabor;
	
	@Column
	private String origem;
	
	@Column
	private int estoque;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="id_estilo")
	private Estilo estilo;
	
//	@OneToMany(mappedBy = "cerveja_id")
//	private Set<ItenVenda> iten = new HashSet<>();
	
	public Cerveja() {
		
	}

	
	
	public Cerveja(Long id, String nome, double valor, double teor_alcoolico, String sabor, String origem, int estoque) {
	super();
	this.id = id;
	this.nome = nome;
	this.valor = valor;
	this.teor_alcoolico = teor_alcoolico;
	this.sabor = sabor;
	this.origem = origem;
	this.estoque = estoque;
	this.estilo = estilo;
}

	public Estilo getEstilo() {
		return estilo;
	}


	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public double getTeor_alcoolico() {
		return teor_alcoolico;
	}



	public void setTeor_alcoolico(double teor_alcoolico) {
		this.teor_alcoolico = teor_alcoolico;
	}



	public String getSabor() {
		return sabor;
	}



	public void setSabor(String sabor) {
		this.sabor = sabor;
	}



	public String getOrigem() {
		return origem;
	}



	public void setOrigem(String origem) {
		this.origem = origem;
	}



	public int getEstoque() {
		return estoque;
	}



	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Cerveja other = (Cerveja) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
