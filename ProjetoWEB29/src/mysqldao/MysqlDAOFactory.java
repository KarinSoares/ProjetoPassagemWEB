package mysqldao;

import dao.AeronaveDAO;
import dao.ClienteDAO;
import dao.DAOFactory;
import dao.LoginDAO;
import dao.PassagemDAO;
import dao.ReembolsoDAO;
import dao.VooDAO;

public class MysqlDAOFactory  extends DAOFactory
{
	public static final String DRIVER = "driver do MySQL";
	public static final String DBURL = "string de conexão do MySQL";

	public LoginDAO getLoginDAO(){
		return new MySqlDaoLoginDAO();
	}
	
	public AeronaveDAO getAeronaveDAO(){
		return new MySqlDaoAeronaveDAO();
	}
	
	public VooDAO getVooDAO(){
		return new MySqlDaoVooDAO();
	}
	
	public PassagemDAO getPassagemDAO(){
		return new MySqlDaoPassagemDAO();
	}
	
	public ClienteDAO getClienteDAO(){
		return new MySqlDaoClienteDAO();
	}
	
	public ReembolsoDAO getReembolsoDAO(){
		return new MySqlDaoReembolsoDAO();
	}
}
