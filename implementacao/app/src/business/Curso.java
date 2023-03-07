package business;

import java.util.List;

public class Curso {

	private String nome;

	private int qtdCreditos;

	private List<Semestre> semestres;

	
	public Curso(String nome, int qtdCreditos) {
		this.nome = nome;
		this.qtdCreditos = qtdCreditos;
	}


	public boolean adicionarSemestre() {
		return false;
	}

}
