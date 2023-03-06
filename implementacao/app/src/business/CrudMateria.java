package business;

import java.util.List;

public class CrudMateria implements Crud {

	private static List<Gerenciavel> lista;

	public boolean cadastrar(Gerenciavel gerenciavel) {
		return true;
	}

	public boolean alterar(Gerenciavel gerenciavel) {
		return false;
	}

	public boolean excluir(Gerenciavel gerenciavel) {
		return false;
	}

}
