package business;

import java.util.List;

public class Curso {

	private String Nome;

	private int QtdCreditos;

	private List<Semestre> Semestres;

	
	public Curso(String nome, int qtdCreditos) {
		Nome = nome;
		QtdCreditos = qtdCreditos;
	}


	public boolean adicionarSemestre() {
		return false;
	}

}
