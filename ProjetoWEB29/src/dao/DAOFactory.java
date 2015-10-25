package dao;

import mysqldao.MysqlDAOFactory;

public abstract class DAOFactory {
	public static final int MY_SQL = 0; //banco default
	public static final int POSTGRE = 1;
	//sera preenchida no init do servlet SelecionarCategoriasServlet 
	public static int banco;
	
	public abstract LoginDAO getLoginDAO();
	public abstract AeronaveDAO getAeronaveDAO();
	public abstract VooDAO getVooDAO();
	public abstract PassagemDAO getPassagemDAO();
	public abstract ClienteDAO getClienteDAO();
	public abstract ReembolsoDAO getReembolsoDAO();
	
	public static DAOFactory getDAOFactory() {
		switch (DAOFactory.banco) {
		case DAOFactory.MY_SQL:
			return new MysqlDAOFactory();
		default:
			return null;
		}
	}
}
