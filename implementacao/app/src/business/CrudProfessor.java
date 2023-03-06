package business;

import java.util.ArrayList;
import java.util.List;

public class CrudProfessor implements Crud {
	private static List<Gerenciavel> lista;
	
	public CrudProfessor(){
		lista = new ArrayList<Gerenciavel>();
	}

	public boolean cadastrar(Gerenciavel gerenciavel) {
		lista.add(gerenciavel);
		return true;
	}

	public boolean alterar(Gerenciavel gerenciavel) {
		return false;
	}

	public boolean excluir(Gerenciavel gerenciavel) {
		return false;
	}

}
