import java.util.List;

public class Aluno extends Usuário implements Gerenciavel {

	private int MATRICULA;

	private Semestre semestre;

	private Curso Curso;

	private List<Observer> Observers;

	private double valorAPagar;

	private Observer observer;

	public void attach(Observer observer) {

	}

	public void notifyObservers() {

	}

	public void cancelarMateria(String materia) {

	}

	public void matricular(String materia) {

	}

}
