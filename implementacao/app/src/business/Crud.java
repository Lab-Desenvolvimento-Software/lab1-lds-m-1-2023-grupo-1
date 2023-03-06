package business;

import java.util.List;
public interface Crud {

	public abstract boolean cadastrar(Gerenciavel gerenciavel);

	public abstract boolean alterar(Gerenciavel gerenciavel);

	public abstract boolean excluir(Gerenciavel gerenciavel);

}
