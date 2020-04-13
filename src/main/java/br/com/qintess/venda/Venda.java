package br.com.qintess.venda;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import PK.ClientePK;
import br.com.qintess.cliente.Cliente;
import br.com.qintess.grupo.Usuario;

@Entity
@Table(name = "venda")
public class Venda implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private double valor;
	
	@Column
	private double desconto;
	
	@Column
	private double frete;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date data;
	
	
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name ="id_cliente")
	private Cliente cliente;
	
//	@OneToMany(mappedBy = "venda_id")
//	private Set<ItenVenda> iten =  new HashSet<>();
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name ="id_usuario")
	private Usuario usuario;
	
	public Venda() {
		
	}
	
	

	public Venda(Long id, double valor, double desconto, double frete, Date data ) {
		super();
		this.id = id;
		this.valor = valor;
		this.desconto = desconto;
		this.frete = frete;
		this.data = data;
		this.cliente = cliente;
		
	}



	




	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getFrete() {
		return frete;
	}

	public void setFrete(double frete) {
		this.frete = frete;
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
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	
	
	
	
	
}
