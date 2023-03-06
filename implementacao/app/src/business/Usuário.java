package business;



public abstract class Usuário {

	private String Nome;

	private String Senha;



	public Usuário(String nome, String senha) {
		this.Nome = nome;
		this.Senha = senha;
    }

	public String getNome(){
		return this.Nome;
	}
}
