package model;

import dao.DAOFactory;
import dao.LoginDAO;

public class Especialista {
	public boolean validaLogin(String usuario, String senha)
	{
		LoginDAO dao = DAOFactory.getDAOFactory().getLoginDAO();		
		return dao.validaLogin(usuario, senha);
	}
}