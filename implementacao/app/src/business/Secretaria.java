package business;

import java.util.ArrayList;
import java.util.List;

public class Secretaria extends Usuario {

	private CrudAluno crudAluno;
	private CrudProfessor crudProfessor;
	private CrudMateria crudMateria;
	// Esses list vão sumir depois de ter os arquivos salvos
	private List<Gerenciavel> usuarios;
	public List<Gerenciavel> materias;
	public static List<Curso> cursos;

	public Secretaria(String nome, String senha) {
		super(nome, senha);
		usuarios = new ArrayList<Gerenciavel>();
		materias = new ArrayList<Gerenciavel>();
		cursos = new ArrayList<Curso>();
	}

	public void criar(Gerenciavel gerenciavel) {

		if (gerenciavel.getClass().getTypeName() == "business.Aluno") {
			if (crudAluno == null) {
				crudAluno = new CrudAluno();
			}
			if (crudAluno.cadastrar(gerenciavel)) {
				usuarios.add(gerenciavel);
			}

		} else {
			if (gerenciavel.getClass().getTypeName() == "business.Professor") {
				if (crudProfessor == null) {
					crudProfessor = new CrudProfessor();
				}
				if (crudProfessor.cadastrar(gerenciavel)) {
					usuarios.add(gerenciavel);
				}

			} else {
				if (gerenciavel.getClass().getTypeName() == "business.Materia") {
					if (crudMateria == null) {
						crudMateria = new CrudMateria();
					}
					if (crudMateria.cadastrar(gerenciavel)) {
						materias.add(gerenciavel);
					}

				}
			}
		}
	}

	public Curso getCurso(String nome){
		for(Curso curso : cursos){
			if(curso.getNome().compareTo(nome)==0){
				return curso;
			}
		}
		return null;
	}

	public void criarCurso(String nome, int qtdCreditos){
		Curso curso = new Curso(nome,qtdCreditos);
		cursos.add(curso);
	}

	public void alterar(Gerenciavel gerenciavel) {

	}

	public void excluir(Gerenciavel gerenciavel) {

	}

	public boolean criarSemestre(int numSemestre) {
		return false;
	}

	public List<Gerenciavel> getAllUsers() {
		return usuarios;
	}

	public List<Gerenciavel> getAllMaterias() {
		return materias;
	}

	public String toString() {
		return (this.getNome() + " " + super.getId());
	}

}
