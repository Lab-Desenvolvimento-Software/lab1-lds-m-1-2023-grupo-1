package business;

import java.util.List;
import java.util.ArrayList;

public class Professor extends Usuario implements Gerenciavel {

	private List<Materia> materias;
	private int ID_PROFESSOR;

	public Professor(String nome, String senha) {
		super(nome, senha);
		materias = new ArrayList<Materia>();
	}

	public List<Aluno> getTurma(String nome) {
		for(Materia materia : materias){
			if((materia.getNome().compareTo(nome))==0){
				return materia.getAlunos();
			}
		}
		return null;
	}
	
	public String toString(){
		return ("Nome: " + super.getNome() + " Ocupação: professor");
	}

	public int getID_PROFESSOR() {
		return ID_PROFESSOR;
	}

	public void setID_PROFESSOR(int ID_PROFESSOR) {
		this.ID_PROFESSOR = ID_PROFESSOR;
	}

}
