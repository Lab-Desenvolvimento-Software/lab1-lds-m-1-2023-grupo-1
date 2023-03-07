package business;

import java.util.List;

public class CrudMateria implements Crud {

	//Esses list vão sumir depois de ter os arquivos salvos
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
