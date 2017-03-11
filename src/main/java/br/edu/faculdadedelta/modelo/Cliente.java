package br.edu.faculdadedelta.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.edu.faculdadedelta.generic.BaseEntity;

@Entity
public class Cliente extends BaseEntity<Long>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cliente")
	private long id;
	
	@Column(length = 60, nullable = false)
	private String nome;
	
	@Column(length = 20)
	private String cpf;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Venda> compras;
	
	public Cliente(){
		
	}
	
	

	public Cliente(long id, String nome) {
		this.id = id;
		this.nome = nome;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Venda> getCompras() {
		return compras;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
