package business;

import java.util.ArrayList;
import java.util.List;

public class Materia implements Gerenciavel {

	private String nome;

	private double preco;

	private List<Aluno> alunos;

	private int MIN_ALUNOS = 3;

	private int MAX_ALUNOS = 60;

	private boolean ativa;

	private boolean obrigatoria;

	public Materia(String nome, double preco, boolean status, boolean obrigatoria) {
		alunos = new ArrayList<>();

		this.setNome(nome);
		this.setPreco(preco);
		this.setAtiva(status);
		this.setObrigatoria(obrigatoria);
	}

	public boolean isObrigatoria() {
		return this.obrigatoria;
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

	public void removeAluno(Aluno aluno) {
		alunos.remove(aluno);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public void setObrigatoria(boolean obrigatoria) {
		this.obrigatoria = obrigatoria;
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

	@Override
	public String toString() {
		return ("Nome da materia: " + getNome() + " Obrigatoria: " + this.obrigatoria);
	}
}
