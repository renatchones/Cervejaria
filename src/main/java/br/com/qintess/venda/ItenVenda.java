package br.com.qintess.venda;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import br.com.qintess.cerveja.Cerveja;

@Entity
@Table(name = "itenvenda")
public class ItenVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private double valor_uni;
	
	@Column
	private double quantidade;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name ="id_venda")
	private Venda venda;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name ="id_cerveja")
	private Cerveja cerveja;

	public ItenVenda() {
		
	}

	public ItenVenda(double quantidade, double valor_uni) {
		super();
	
		this.quantidade = quantidade;
		this.valor_uni = valor_uni;
	}
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor_uni() {
		return valor_uni;
	}

	public void setValor_uni(double valor_uni) {
		this.valor_uni = valor_uni;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Cerveja getCerveja() {
		return cerveja;
	}

	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}
	

}