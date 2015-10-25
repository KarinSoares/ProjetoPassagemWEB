package control;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import model.Especialista;
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config)
	{
		//try {
			// Pega o contexto do JNDI
			//Context env = (Context) new InitialContext().lookup("java:comp/env");

			// pega qual o banco de dados a utilizar
			// MySQL e o default
			// a configuracao esta no web.xml no WebContent/WEB-INF do projeto
			
			//String banco = (String) env.lookup("banco-de-dados");
			
			String banco = "mysql";
			
			if (banco.equals("mysql")) {
				DAOFactory.banco = DAOFactory.MY_SQL;
			} else if (banco.equals("postgresql")) {
				DAOFactory.banco = DAOFactory.POSTGRE;
			} else {
				DAOFactory.banco = DAOFactory.MY_SQL;
			}
		/*} catch (NamingException e1) {
			// MySQL e o default
			DAOFactory.banco = DAOFactory.MY_SQL;
			e1.printStackTrace();
		}*/
	}

	/**
	 * Default constructor.
	 */
	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");

		Especialista esp = new Especialista();
		if (esp.validaLogin(usuario, senha))
		{
			response.setContentType("text/html");
			String pagina = "menu.html";//link pag
			response.sendRedirect(pagina);
		}
		else
		{
			response.setContentType("text/html");
			response.sendRedirect("USUÁRIO INVÁLIDO");
		}
	}

}
