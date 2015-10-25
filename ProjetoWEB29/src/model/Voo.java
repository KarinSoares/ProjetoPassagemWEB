package model;

import dao.DAOFactory;
import dao.VooDAO;

public class Voo
{
	private int codVoo;
	private String aeroportoOrigem;
	private String aeroportoDestino;
	private String dataHora;
	private String situacao;
	private Aeronave aeronave;
	
	public Voo()
	{
		this.aeronave =  new Aeronave();
	}
	
	public int getCodVoo() {
		return codVoo;
	}
	public void setCodVoo(int codVoo) {
		this.codVoo = codVoo;
	}
	public String getAeroportoOrigem() {
		return aeroportoOrigem;
	}
	public void setAeroportoOrigem(String aeroportoOrigem) {
		this.aeroportoOrigem = aeroportoOrigem;
	}
	public String getAeroportoDestino() {
		return aeroportoDestino;
	}
	public void setAeroportoDestino(String aeroportoDestino) {
		this.aeroportoDestino = aeroportoDestino;
	}
	
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	public int getAeronave() {
		return aeronave.getCodAeronave();
	}
	public void setAeronave(int CodAeronave) {
		this.aeronave.setCodAeronave(CodAeronave);
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public void incluir() throws Exception
	{
		String msg = "";
		
		if(this.getAeroportoOrigem() == "")
			msg += ("Digite aeroporto de origem!");
		
		if(this.getAeroportoDestino()== "")
			msg += ("\nDigite aeroporto de destino!");
		
		if(this.getDataHora().toString() == "")
			msg += ("\nDigite data/hora!");
		
		if(this.getAeronave() <= 0)
			msg += ("\nDigite o código da aeronave!");
		
		if(this.getSituacao() == "")
			msg += ("\nDigite situação!");
		
		if(msg != "")
			throw new Exception(msg);
		
		VooDAO dao = DAOFactory.getDAOFactory().getVooDAO();		
		dao.incluir(this);		
	}
	
	public void excluir() throws Exception
	{
		String msg = "";
		
		if(this.getCodVoo() <= 0)
			msg += ("Busque o voo primeiro para realizar a exclusão!");
		
		if(msg != "")
			throw new Exception(msg);
		
		VooDAO dao = DAOFactory.getDAOFactory().getVooDAO();		
		dao.excluir(this);		
	}
	
	public void alterar() throws Exception
	{
		String msg = "";
		
		if(this.getCodVoo() <= 0)
			msg += ("Busque o voo primeiro para realizar a alteração!");
		
		if(this.getAeroportoOrigem() == "")
			msg += ("\nDigite aeroporto de origem!");
		
		if(this.getAeroportoDestino()== "")
			msg += ("\nDigite aeroporto de destino!");
		
		if(this.getDataHora().toString() == "")
			msg += ("\nDigite data/hora!");
		
		if(this.getAeronave() <= 0)
			msg += ("\nDigite o código da aeronave!");
		
		if(this.getSituacao() == "")
			msg += ("\nDigite situação!");
		
		if(msg != "")
			throw new Exception(msg);
		
		VooDAO dao = DAOFactory.getDAOFactory().getVooDAO();		
		dao.alterar(this);		
	}
	
	public Voo consultar(String codigoPesquisa) throws Exception
	{
		Voo voo = new Voo(); 
		
		if(codigoPesquisa == "" || (Integer.parseInt(codigoPesquisa)) <= 0)
			throw new Exception("Digite código para busca!");
		
		VooDAO dao = DAOFactory.getDAOFactory().getVooDAO();		
		voo = dao.carregar((Integer.parseInt(codigoPesquisa)));
		
		if(voo == null || voo.getCodVoo() == 0)
			throw new Exception("Voo não cadastrada!");
		
		//Voo OK
		return voo;
	}
}
