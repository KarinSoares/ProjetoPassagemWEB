package dao;

import model.Pagamento;
import model.Passagem;
import model.Reembolso;

public interface ReembolsoDAO {
	public void cancelarPassagem(Reembolso reembolso, Pagamento pagamento, Passagem passagem);

	public void cancelarPassagem(String numeroBilhete, String banco,
			String agencia, String contaCorrente, String nomeTitular,
			String cpf, String valorReembolso, String dataCancelamento);
}
