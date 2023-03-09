package business;

import java.io.Serializable;

public abstract class Usuario implements Serializable {

	private String nome;
	private int id;
	private static int lastId;
	private String senha;

	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
		this.id = lastId + 1;
		lastId = this.id;
	}

	public String getSenha() {
		return this.senha;
	}

	public String getNome() {
		return this.nome;
	}

	public int getId() {
		return this.id;
	}

}
