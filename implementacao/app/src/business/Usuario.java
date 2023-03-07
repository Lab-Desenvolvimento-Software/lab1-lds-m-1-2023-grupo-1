package business;



public abstract class Usuario {

	private String Nome;

	private String Senha;



	public Usuario(String nome, String senha) {
		this.Nome = nome;
		this.Senha = senha;
	}

	public String getNome(){
		return this.Nome;
	}
}
