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
		// TODO Auto-generated constructor stub
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
}
