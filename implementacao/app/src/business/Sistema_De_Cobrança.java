package business;

public class Sistema_De_Cobrança implements Observer {

	private int attribute17;

	public Sistema_De_Cobrança(Aluno aluno) {
		super(aluno);
	}

	@Override
	public void notify(Aluno aluno) {
		this.cobrar(aluno);
	}

	private void cobrar(Aluno aluno) {
		aluno.setValorAPAgar(1500L);
	}

}
