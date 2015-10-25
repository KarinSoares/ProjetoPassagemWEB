package model;

import dao.DAOFactory;
import dao.ReembolsoDAO;

public class Reembolso {
	
	private int codReembolso;
	private Passagem codigo;
	private Passagem dataCancelamento;
	private Pagamento banco;
	private Pagamento agencia;
	private Pagamento contaCorrente;
	private Pagamento nomeTitular;
	private Pagamento cpf; 
	private double valorReembolso;

	public int getCodigo() {
		return codReembolso;
	}

	public void setCodigo(int codReembolso) {
		this.codReembolso = codReembolso;
	}

	public Passagem getNumeroBilhete() {
		return codigo;
	}

	public void setNumeroBilhete(Passagem codigo) {
		this.codigo = codigo;
	}

	public Passagem getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Passagem dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public Pagamento getBanco() {
		return banco;
	}

	public void setBanco(Pagamento banco) {
		this.banco = banco;
	}

	public Pagamento getAgencia() {
		return agencia;
	}

	public void setAgencia(Pagamento agencia) {
		this.agencia = agencia;
	}

	public Pagamento getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(Pagamento contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Pagamento getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(Pagamento nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public Pagamento getCpf() {
		return cpf;
	}

	public void setCpf(Pagamento cpf) {
		this.cpf = cpf;
	}

	public double getValorReembolso() {
		return valorReembolso;
	}

	public void setValorReembolso(double valorReembolso) {
		this.valorReembolso = valorReembolso;
	}
	

	public void cancelarPassagem(String numeroBilhete, String banco, String agencia, 
			String contaCorrente, String nomeTitular,String	cpf, String valorReembolso, String dataCancelamento ) throws Exception
	{
		String msg = "";
		
		if(numeroBilhete == null || numeroBilhete == "" || Integer.parseInt(numeroBilhete) <= 0)
			msg += ("Digite o número do bilhete!");
		
		if(banco == null || banco == "")
			msg += ("\nDigite o código do banco!");
		
		if(agencia == null || agencia == "")
			msg += ("\nDigite a agencia do banco!");
		
		if(contaCorrente == null || contaCorrente == "")
			msg += ("\nDigite a conta corrente do banco!");
		
		if(nomeTitular == null || nomeTitular == "")
			msg += ("\nDigite o nome do titular!");
		
		if(cpf == null || cpf == "")
			msg += ("\nDigite o cpf do titular!");
		
		if(valorReembolso == null || valorReembolso == "" || Double.parseDouble(valorReembolso) <= 0)
			msg += ("\nDigite o valor do reembolso da passagem!");
				
		if(msg != "")
			throw new Exception(msg);
		
		ReembolsoDAO dao = DAOFactory.getDAOFactory().getReembolsoDAO();		
		dao.cancelarPassagem( numeroBilhete,  banco,  agencia, 
				 contaCorrente,  nomeTitular,	cpf,  valorReembolso,  dataCancelamento);
		
	}
}
