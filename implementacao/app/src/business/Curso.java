package business;

import java.util.ArrayList;
import java.util.List;

public class Curso {

	private String nome;

	private int qtdCreditos;

	private List<Materia> materias;

	public Curso(String nome, int qtdCreditos) {
		materias = new ArrayList<Materia>();
		this.nome = nome;
		this.qtdCreditos = qtdCreditos;
	}

	public List<Materia> getAllMaterias(){
		return materias;
	}

	public void adicionarMateria(Materia materia){
		materias.add(materia);
	}

	public String getNome(){
		return nome;
	}

}
