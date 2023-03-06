package business;

import java.util.List;

public class Aluno extends Usuario implements Gerenciavel {

	private int MATRICULA;

	private Semestre semestre;

	private Curso curso;

	private List<Observer> observers;

	private double valorAPagar;

	private Observer observer;

	public void attach(Observer observer) {
		this.observers.add(observer);
	}

	public void notifyAllObservers() {
		this.observers.stream().forEach(observerController -> observerController.notify(this));
	}

	public void cancelarMateria(String materia) {

	}

	public void matricular(String materia) {
		this.notifyAllObservers();
	}

	public void setValorAPAgar(long valorAPagar) {
		this.valorAPagar = valorAPagar;
	}
}
