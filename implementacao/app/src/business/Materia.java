package business;

import java.util.List;

public class Materia implements Gerenciavel {

	private String nome;

	private int preco;

	private List<Aluno> alunos;

	private int MIN_ALUNOS = 3;

	private int MAX_ALUNOS = 60;

	private boolean ativa;

	private boolean obrigatoria;

	public boolean isObrigatoria() {
		return obrigatoria;
	}

	private List<Curso> cursos;

	private List<Professor> professores;

	public boolean estaAtiva() {
		int numAlunos = this.alunos.size();

		if(numAlunos >= MIN_ALUNOS && numAlunos <= MAX_ALUNOS) {
			this.ativa = true;
		} else {
			this.ativa = false;
		}

		return this.ativa;
	}

	public void addAluno(Aluno aluno) {
		if(estaAtiva()) {
			alunos.add(aluno);
		}
	}

}
