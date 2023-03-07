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
	
	public Materia(String nome, int preco, Boolean status) {
		this.setNome(nome);
		this.setPreco(preco);
		this.setAtiva(status);
		
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getPreco() {
		return Preco;
	}

	public void setPreco(int preco) {
		Preco = preco;
	}

	public List<Aluno> getAlunos() {
		return Alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		Alunos = alunos;
	}

	public void setAtiva(boolean ativa) {
		Ativa = ativa;
	}

	public boolean isObrigatoria() {
		return Obrigatoria;
	}

	public void setObrigatoria(boolean obrigatoria) {
		Obrigatoria = obrigatoria;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void addProfessores(Professor professor) {
		this.professores.add(professor);
	}
	
	public String toString() {
		return ("Nome da materia: " + this.Nome + " Obrigatoria: " + this.Obrigatoria);
	}

}
