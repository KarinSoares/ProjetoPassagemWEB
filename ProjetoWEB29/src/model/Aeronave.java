package model;
import dao.AeronaveDAO;
import dao.DAOFactory;

public class Aeronave
{
	private int codAeronave;
	private String nmAeronave;
	private int qtdeAssAeronave;
	private String localizacaoAssento;

	public Aeronave()
	{
		setCodAeronave(0);
		setNmAeronave("");
		setQtdeAssAeronave(0);
		setLocalizacaoAssento("");
	}	
	
	public Aeronave(int codAeronave, String nmAeronave, int qtdeAssAeronave, String localizacaoAssento) 
	{
		setCodAeronave(codAeronave);
		setNmAeronave(nmAeronave);
		setQtdeAssAeronave(qtdeAssAeronave);
		setLocalizacaoAssento(localizacaoAssento);
	}

	public int getCodAeronave() {
		return codAeronave;
	}

	public void setCodAeronave(int codAeronave) {
		this.codAeronave = codAeronave;
	}

	public String getLocalizacaoAssento() {
		return localizacaoAssento;
	}

	public void setLocalizacaoAssento(String localizacaoAssento) {
		this.localizacaoAssento = localizacaoAssento;
	}

	public String getNmAeronave() {
		return nmAeronave;
	}

	public void setNmAeronave(String nmAeronave) {
		this.nmAeronave = nmAeronave;
	}

	public int getQtdeAssAeronave() {
		return qtdeAssAeronave;
	}

	public void setQtdeAssAeronave(int qtdeAssAeronave) {
		this.qtdeAssAeronave = qtdeAssAeronave;
	}
	
	public void incluir() throws Exception
	{
		String msg = "";
		
		if(this.getNmAeronave() == "")
			msg += ("Digite nome da aeronave!");
		
		if(this.getLocalizacaoAssento() == "")
			msg += ("\nDigite Localização do Assento da aeronave!");
		
		if(this.getQtdeAssAeronave() <= 0)
			msg += ("\nDigite quantidade de assento da aeronave!");
		
		if(msg != "")
			throw new Exception(msg);
		
		AeronaveDAO dao = DAOFactory.getDAOFactory().getAeronaveDAO();		
		dao.incluir(this);
	}
	
	public void excluir() throws Exception
	{
		String msg = "";
		
		if(this.getCodAeronave() <= 0)
			msg += ("Busque a aeronave primeiro para realizar a exclusão!");
		
		if(msg != "")
			throw new Exception(msg);
		
		AeronaveDAO dao = DAOFactory.getDAOFactory().getAeronaveDAO();		
		dao.excluir(this);		
	}
	
	public void alterar() throws Exception
	{
		String msg = "";
		
		if(this.getCodAeronave() <= 0)
			msg += ("Busque a aeronave primeiro para realizar a alteração!");
		
		if(this.getNmAeronave() == "")
			msg += ("\nDigite nome da aeronave!");
		
		if(this.getLocalizacaoAssento() == "")
			msg += ("\nDigite Localização do Assento da aeronave!");
		
		if(this.getQtdeAssAeronave() <= 0)
			msg += ("\nDigite quantidade de assento da aeronave!");
		
		if(msg != "")
			throw new Exception(msg);
		
		AeronaveDAO dao = DAOFactory.getDAOFactory().getAeronaveDAO();		
		dao.alterar(this);
	}
	
	public Aeronave consultarAeronave(String codigoPesquisa) throws Exception
	{
		Aeronave aeronave = new Aeronave(); 
		
		if(codigoPesquisa == "" || (Integer.parseInt(codigoPesquisa)) <= 0)
			throw new Exception("Digite código para busca!");
		
		AeronaveDAO dao = DAOFactory.getDAOFactory().getAeronaveDAO();		
		aeronave = dao.carregar((Integer.parseInt(codigoPesquisa)));
		
		if(aeronave == null || aeronave.getCodAeronave() == 0)
			throw new Exception("Aeronave não cadastrada!");
		
		//Aeronave OK
		return aeronave;
	}	
}
