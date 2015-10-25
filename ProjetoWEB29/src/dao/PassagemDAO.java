package dao;

import java.util.ArrayList;

import model.Pagamento;
import model.Passagem;
import model.Voo;

public interface PassagemDAO {
	
	public void alterarAssento(Passagem passagem);
	
	public boolean consultarAssentoVago(Passagem passagem);
	
	public Passagem consultarCheckIn( Passagem passagem);
	
	public ArrayList<Passagem> consultarPasssagensVendidas(Passagem passagem);

	public ArrayList<Voo> buscarPassagem(String origem, String destino, int quantidade);
	
	public void incluirPagamento(Pagamento pagamento);
	
	public void incluirPassagem(int codPagamento, int codCliente, int codVoo);
}
