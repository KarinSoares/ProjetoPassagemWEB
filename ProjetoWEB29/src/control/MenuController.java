package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Passagem;

/**
 * Servlet implementation class MenuController
 */
@WebServlet("/menu.do")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String opcao = request.getParameter("opcao");
		String pagina = "menu.html";//link pag
		
		switch(opcao)
		{
			case "Aeronave":
				pagina = "aeronave.jsp";				
				break;
			case "Voo":
				pagina = "voo.jsp";
				break;
			case "Comprar":
				pagina = "comprar_passagem.jsp";
				break;
			case "Check-in":
				pagina = "check_in.jsp";
				break;
			case "Cancelar":
				pagina = "cancelar_passagem.jsp";
				break;
			case "Voltar":
				pagina = "menu.html";
				break;
			case "Consultar":
				HttpSession session = request.getSession();
				
				Passagem passagem =  new Passagem();
				
				String impressaoPassagem = passagem.consultarPasssagensVendidas();
				
				if(impressaoPassagem == null)
					impressaoPassagem = "Não existem passagens para a data atual";
				
				session.setAttribute("impressaoPassagem", impressaoPassagem);
				RequestDispatcher view = request.getRequestDispatcher("consultar.jsp");
				view.forward(request, response);
				
				break;
			default:
				pagina = "erro";
				break;
		}
		
		if(pagina != "")
		{
			response.setContentType("text/html");
			response.sendRedirect(pagina);
		}
	}
	
}
