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

	public Secretaria(String nome, String senha) {
		super(nome, senha);
		usuarios = new ArrayList<Gerenciavel>();
		materias = new ArrayList<Gerenciavel>();
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

	public void alterar(Gerenciavel gerenciavel) {

	}

	public void excluir(Gerenciavel gerenciavel) {

	}

	public boolean criarSemestre(int numSemestre) {
		return false;
	}

	public void vincularSemestreAoCurso(Semestre semestre, Curso curso) {

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
