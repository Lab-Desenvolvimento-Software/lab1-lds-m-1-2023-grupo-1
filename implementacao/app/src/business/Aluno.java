package business;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario implements Gerenciavel {

	private int MATRICULA;

	private Semestre semestre;

	private Curso curso;

	private List<Observer> observers;
	private List<Materia> materiasObrigatoriasMatriculadas;
	private List<Materia> optativasMatriculadas;
	private double valorAPagar;

	private Observer observer;

	public Aluno(String nome, String senha, Curso curso) {
		super(nome, senha);
		this.setCurso(curso);

		observers = new ArrayList<>();
		materiasObrigatoriasMatriculadas = new ArrayList<>();
		optativasMatriculadas = new ArrayList<>();
	}

	public void attach(Observer observer) {
		this.observers.add(observer);
	}

	public void notifyAllObservers(Materia materia) {
		this.observers.stream().forEach(observerController -> observerController.notify(this, materia.getPreco()));
	}

	public void cancelarMateria(Materia materia) {
		if(materiasObrigatoriasMatriculadas.contains(materia) || optativasMatriculadas.contains(materia)) {
			materia.removeAluno(this);
			materiasObrigatoriasMatriculadas.remove(materia);
			optativasMatriculadas.remove(materia);
		}
	}

	private boolean quantMateriasMatriculadas() {
		if((materiasObrigatoriasMatriculadas.size() < 4) && (optativasMatriculadas.size() < 2)) {
			return true;
		}

		return false;
	}

	public boolean matricular(Materia materia) throws IndexOutOfBoundsException {
		if(quantMateriasMatriculadas()) {
			materia.addAluno(this);

			if(materia.isObrigatoria()) {
				materiasObrigatoriasMatriculadas.add(materia);
			} else {
				optativasMatriculadas.add(materia);
			}

			this.notifyAllObservers(materia);

			return true;
		}

		throw new IndexOutOfBoundsException("É possível matricular em apenas 4 disciplinas obrigatórias e 2 optativas");
	}

	public void setValorAPAgar(double valorAPagar) {
		this.valorAPagar = valorAPagar;
	}
	public String toString(){
		return ("Nome: " + super.getNome() + " Ocupação: aluno");
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public int getMATRICULA() {
		return MATRICULA;
	}

	public void setMATRICULA(int matricula) {
		MATRICULA = matricula;
	}
}
