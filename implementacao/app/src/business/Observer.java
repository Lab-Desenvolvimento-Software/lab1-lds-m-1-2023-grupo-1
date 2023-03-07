package business;

public abstract class Observer {
	private Aluno aluno;

	public Observer(Aluno aluno) {
		this.aluno = aluno;
		this.aluno.attach(this);
	}

	public abstract void notify(Aluno aluno, double preco);
}
