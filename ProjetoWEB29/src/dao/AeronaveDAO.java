package dao;

import model.Aeronave;

public interface AeronaveDAO {
	
	public void incluir(Aeronave aeronave);
	
	public void alterar(Aeronave aeronave);
	
	public void excluir(Aeronave aeronave);
	
	public Aeronave carregar(int codigo);
}
