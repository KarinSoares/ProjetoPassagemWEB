package model;

import dao.DAOFactory;
import dao.PassagemDAO;

public class Pagamento {
	
	private int codigo;
	private double valor;
	private String tipoCartao;
	private String nomeTitular;
	private String cpf;
	private String numeroCartao;
	private String dataValidade;
	private String codSeguranca;
	private String banco;
	private String agencia;
	private String conta;
	private String email;
	private String telefone;
	
	public Pagamento()
	{		
		
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getTipoCartao() {
		return tipoCartao;
	}
	public void setTipoCartao(String tipoCartao) {
		this.tipoCartao = tipoCartao;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public String getCodSeguranca() {
		return codSeguranca;
	}
	public void setCodSeguranca(String codSeguranca) {
		this.codSeguranca = codSeguranca;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void incluir() throws Exception
	{
		String msg = "";
		
		if(this.getValor() <= 0)
			msg += (" \nDigite valor!");
		
		if(this.getTipoCartao() == "")
			msg += (" \nDigite tipo de cartão!");
		
		if(this.getNomeTitular() == "")
			msg += (" \nDigite nome titular!");
		
		if(this.getCpf() == "")
			msg += (" \nDigite cpf!");
		
		if(this.getNumeroCartao() == "")
			msg += (" \nDigite número cartao!");
		
		if(this.getDataValidade() == "")
			msg += (" \nDigite data validade!");
		
		if(this.getCodSeguranca() == "")
			msg += (" \nDigite codigo de segurança!");
		
		if(this.getBanco() == "")
			msg += (" \nDigite banco!");
		
		if(this.getAgencia() == "")
			msg += (" \nDigite agencia!");
		
		if(this.getConta() == "")
			msg += (" \nDigite conta!");
		
		if(this.getEmail() == "")
			msg += (" \nDigite email!");
		
		if(this.getTelefone() == "")
			msg += (" \nDigite telefone!");
		
		if(msg != "")
			throw new Exception(msg);	
		
		PassagemDAO dao = DAOFactory.getDAOFactory().getPassagemDAO();
		dao.incluirPagamento(this);		
	}
}
