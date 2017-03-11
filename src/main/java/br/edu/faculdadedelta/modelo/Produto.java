package br.edu.faculdadedelta.modelo;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.faculdadedelta.generic.BaseEntity;

@Entity
@Table(name = "produto")
public class Produto extends BaseEntity<Long>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "nm_produto", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "nm_fabricante", length = 50)
	@Basic(fetch = FetchType.LAZY, optional = true)
	private String fabricante;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_validade")
	@Basic(fetch = FetchType.LAZY)
	private Date validade;
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}



	
}
