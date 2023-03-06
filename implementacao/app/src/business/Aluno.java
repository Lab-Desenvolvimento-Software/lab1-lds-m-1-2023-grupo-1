package business;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario implements Gerenciavel {

	private static int MATRICULA = 0;

	private Semestre semestre;

	private Curso curso;

	private List<Observer> observers;
	private List<Materia> materiasObrigatoriasMatriculadas;
	private List<Materia> optativasMatriculadas;
	private double valorAPagar;

	private Observer observer;

	public Aluno(Semestre semestre) {
		observers = new ArrayList<>();
		materiasObrigatoriasMatriculadas = new ArrayList<>();
		optativasMatriculadas = new ArrayList<>();
		MATRICULA++;

		this.semestre = semestre;
	}

	public void attach(Observer observer) {
		this.observers.add(observer);
	}

	public void notifyAllObservers() {
		this.observers.stream().forEach(observerController -> observerController.notify(this));
	}

	public void cancelarMateria(Materia materia) {

	}

	private boolean quantMateriasMatriculadas() {
		if((materiasObrigatoriasMatriculadas.size() < 4) && (optativasMatriculadas.size() < 2)) {
			return true;
		}

		return false;
	}

	public void matricular(Materia materia) {
		if(quantMateriasMatriculadas()) {
			materia.addAluno(this);

			if(materia.isObrigatoria()) {
				materiasObrigatoriasMatriculadas.add(materia);
			} else {
				optativasMatriculadas.add(materia);
			}

			this.notifyAllObservers();
		}
	}

	public void setValorAPAgar(long valorAPagar) {
		this.valorAPagar = valorAPagar;
	}
}