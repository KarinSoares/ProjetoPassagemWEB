package dao;

import model.Voo;

public interface VooDAO {
	
	public void incluir(Voo voo);
	
	public void alterar(Voo voo);
	
	public void excluir(Voo voo);
	
	public Voo carregar(int codigo);
}
