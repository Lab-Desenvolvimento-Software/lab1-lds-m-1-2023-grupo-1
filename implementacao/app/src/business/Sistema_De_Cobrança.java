package business;

public class Sistema_De_Cobrança extends Observer {

	private Aluno aluno;

	public Sistema_De_Cobrança(Aluno aluno) {
		super(aluno);
	}

	@Override
	public void notify(Aluno aluno, double preco) {
		this.cobrar(aluno, preco);
	}

	private void cobrar(Aluno aluno, double preco) {
		aluno.setValorAPAgar(preco);
	}

}
