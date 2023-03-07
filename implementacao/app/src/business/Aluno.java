package business;

import java.util.List;

public class Aluno extends Usuário implements Gerenciavel {

	private int MATRICULA;

	private Semestre semestre;

	private Curso Curso;

	private List<Observer> Observers;

	private double valorAPagar;

	private Observer observer;

	public Aluno(String nome, String senha, Curso curso) {
		super(nome, senha);
		this.setCurso(curso);
	}

	public void attach(Observer observer) {

	}

	public void notifyObservers() {

	}

	public void cancelarMateria(String materia) {

	}

	public void matricular(String materia) {

	}

	public String toString(){
		return ("Nome: " + super.getNome() + " Ocupação: aluno");
	}

	public Curso getCurso() {
		return Curso;
	}

	public void setCurso(Curso curso) {
		Curso = curso;
	}

	public int getMATRICULA() {
		return MATRICULA;
	}

	public void setMATRICULA(int mATRICULA) {
		MATRICULA = mATRICULA;
	}
}
