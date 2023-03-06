package business;

import java.util.ArrayList;
import java.util.List;

public class Secretária extends Usuário {

	private int ID_SECRETARIA;
	private CrudAluno crudAluno;
	private CrudProfessor crudProfessor;
	private List<Gerenciavel> usuarios;

	public Secretária(String nome, String senha, int id) {
		super(nome, senha);
		this.ID_SECRETARIA = id;
		usuarios = new ArrayList<Gerenciavel>();
	}

	public List<Gerenciavel> criar(Gerenciavel gerenciavel) {

		if (gerenciavel.getClass().getTypeName() == "business.Aluno") {
			if (crudAluno == null) {
				crudAluno = new CrudAluno();
			}
			if(crudAluno.cadastrar(gerenciavel)) {
				usuarios.add(gerenciavel);
				return usuarios;
			}
			
		} else {
			if (gerenciavel.getClass().getTypeName() == "business.Professor") {
				if (crudProfessor == null) {
					crudProfessor = new CrudProfessor();
				}
				if(crudProfessor.cadastrar(gerenciavel)) {
					usuarios.add(gerenciavel);
					return usuarios;
				}
				
			}
		}
		return null;
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

}
