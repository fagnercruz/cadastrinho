package br.anisoft.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PessoaModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String sobrenome;
	
	/* comentario inserido apenas para testar o github */
	/* comentário para verificar o retorno */

	
	// Métodos getters e Setters
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String contatenarNome() {
		return nome + " " + sobrenome;
	}

	// Equals e hashcode gerados automaticamente e configurados para usar somente o ID como parâmetro
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		PessoaModel other = (PessoaModel) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
