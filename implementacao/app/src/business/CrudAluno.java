package business;

import java.util.ArrayList;
import java.util.List;

public class CrudAluno implements Crud {

	// Esses list vão sumir depois de ter os arquivos salvos
	private List<Gerenciavel> lista;

	public CrudAluno() {
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
