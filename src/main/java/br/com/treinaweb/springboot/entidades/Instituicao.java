package br.com.treinaweb.springboot.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Instituicao {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(length = 30)
	private String nome;
	
	@Column(length = 100)
	private String endereco;

	@OneToMany(mappedBy = "instituicao")//representa o link entre instituicao e aluno
	public Set<Aluno> alunos;
	
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
