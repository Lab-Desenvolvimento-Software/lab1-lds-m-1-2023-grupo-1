package business;


import java.util.List;

public class Materia implements Gerenciavel {

	private String Nome;

	private int Preco;

	private List<Aluno> Alunos;

	private int MIN_ALUNOS = 3;

	private int MAX_ALUNOS = 60;

	private boolean Ativa;

	private boolean Obrigatoria;

	private List<Curso> cursos;

	private List<Professor> professores;

	public boolean estaAtiva() {
		return false;
	}

}
