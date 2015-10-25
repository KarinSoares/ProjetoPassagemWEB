package model;

import dao.ClienteDAO;
import dao.DAOFactory;

public class Cliente {
	
	public int codigo;
	public int tipoCliente;
	public String tratamento;
	public String nome;
	public String sobrenome;
	public String email;
	public String dataNascimento;
	
	public Cliente()
	{
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente)
	{
		switch(tipoCliente.toUpperCase())
		{	
			case "ADULTO":
				this.tipoCliente = 1;
				break;
			case "CRIANÇA":
				this.tipoCliente = 2;
				break;
			case "BEBÊ":
				this.tipoCliente = 3;
				break;
			default:
				this.tipoCliente = 0;
				break;
		}
		
	}
	public String getTratamento() {
		return tratamento;
	}
	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String date) {
		this.dataNascimento = date;
	}
	
	public void incluir() throws Exception
	{
		String msg = "";
		
		if(this.getTipoCliente() <= 0)
			msg += ("Digite tipo de cliente!");
		
		if(this.getTratamento() == "")
			msg += ("\nDigite tratamento do cliente!");
		
		if(this.getNome() == "")
			msg += ("\nDigite nome do cliente!");
		
		if(this.getSobrenome() == "")
			msg += ("\nDigite sobrenome do cliente!");
		
		if(this.getDataNascimento().toString() == "")
			msg += ("\nDigite data de nascimento cliente!");
		
		if(msg != "")
			throw new Exception(msg);	
		
		ClienteDAO dao = DAOFactory.getDAOFactory().getClienteDAO();		
		dao.incluir(this);		
	}
}
