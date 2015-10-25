package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.DAOFactory;
import dao.PassagemDAO;

public class Passagem {
	
	private int codigo;
	private Pagamento pagamento;
	private Cliente cliente;
	private Voo voo;
	private String dataCancelamento;
	private int codigoAssento;
	
		
	public Passagem()
	{
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Voo getVoo() {
		return voo;
	}
	public void setVoo(Voo voo) {
		this.voo = voo;
	}
	public String getDataCancelamento() {
		return dataCancelamento;
	}
	public void setDataCancelamento(String dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}
	
	public int getCodigoAssento() {
		return codigoAssento;
	}

	public void setCodigoAssento(int codigoAssento) {
		this.codigoAssento = codigoAssento;
	}

	
	
	public String consultarPasssagensVendidas()
	{
		Date data = new Date(System.currentTimeMillis());    
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");   
		  
		String consultaPassagens = "Passagens => <br/><br/>" + formatarDate.format(data);
		
		PassagemDAO dao = DAOFactory.getDAOFactory().getPassagemDAO();
		ArrayList<Passagem> pas= dao.consultarPasssagensVendidas(this);
		
		for (Passagem pa:pas) 
		{
			consultaPassagens +=
					"<br/>Passagem...-> N°..: " + pa.getCodigo() +
					"<br/>Passageiro.-> Nome: " + pa.getCliente().nome +
					"<br/>Vôo........-> Cod.: " + pa.getVoo().getCodVoo() +
					"<br/>Origem: " + pa.getVoo().getAeroportoDestino() +
					"<br/>Destino:" + pa.getVoo().getAeroportoOrigem() + "<br/><br/>";
		}
			
		return consultaPassagens;
	}
	
	public Passagem consultarCheckIn()
	{
		PassagemDAO dao = DAOFactory.getDAOFactory().getPassagemDAO();		
		return dao.consultarCheckIn(this);
	}
	
	public boolean consultarAssentoLivre()
	{
		PassagemDAO dao = DAOFactory.getDAOFactory().getPassagemDAO();
		return dao.consultarAssentoVago(this);
	}
	
	public void alterarAssento(String bilhete, String nrAssento) throws Exception
	{
		String msg = "";
		
		if(bilhete == null || bilhete == "" || Integer.parseInt(bilhete) <= 0)
			msg += ("Digite um bilhete da aeronave!");
		
		if(nrAssento == null || nrAssento == "" || Integer.parseInt(nrAssento) <= 0)
			msg += ("\nDigite código do assento!");
		
		if(msg != "")
			throw new Exception(msg);
		
		this.setCodigo(Integer.parseInt(bilhete));
		this.setCodigoAssento(Integer.parseInt(nrAssento));
		
		boolean vago = this.consultarAssentoLivre();
		
		if (!vago)
		{
			PassagemDAO dao = DAOFactory.getDAOFactory().getPassagemDAO();
			dao.alterarAssento(this);
		}
		else
			msg += ("\nAssento Ocupado, selecione outro código!");
		
		if(msg != "")
			throw new Exception(msg);			
	}
	
	public String buscarPassagem(String origem, String destino, String quantidade)
	{
		int qtde = quantidade == null ? 0 : Integer.parseInt(quantidade);
		
		PassagemDAO dao = DAOFactory.getDAOFactory().getPassagemDAO();
		ArrayList<Voo> voos = dao.buscarPassagem(origem, destino, qtde);
		
		String consultaPassagens = "";
		
		for (Voo voo:voos) 
		{
			consultaPassagens +=
					"<br/>" + voo.getCodVoo() +
					" - " + voo.getAeroportoOrigem() +
					" - " + voo.getAeroportoDestino() + 
					" - " + voo.getDataHora();
		}
			
		return consultaPassagens;
		
	}
	
	public void incluir(int codPagamento, String[] codigoClientes, int codVoo) throws Exception
	{
		String msg = "";
		
		if(codPagamento <= 0)
			msg += (" \nERRO PAGAMENTO!");
		
		if(codVoo <= 0)
			msg += (" \nERRO VOO!");
		
		if(msg != "")
			throw new Exception(msg);
		
		for (String codCliente : codigoClientes)
		{
			if(codCliente == null || codCliente == "0" || codCliente == "")
				msg += (" \nERRO CLIENTE!");
			
			if(msg != "")
				throw new Exception(msg);
			
			PassagemDAO dao = DAOFactory.getDAOFactory().getPassagemDAO();
			dao.incluirPassagem(codPagamento, Integer.parseInt(codCliente), codVoo);
		}			
	}
}
