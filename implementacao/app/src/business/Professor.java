package business;

import java.util.List;

public class Professor extends Usuário implements Gerenciavel {

	public Professor(String nome, String senha) {
		super(nome, senha);
		//TODO Auto-generated constructor stub
	}

	private int ID_PROFESSOR;

	private List<Materia> Materiais;

	public List<Aluno> getTurma(String nome) {
		return null;
	}
	
	public String toString(){
		return ("Nome: " + super.getNome() + " Ocupação: professor");
	}

}
