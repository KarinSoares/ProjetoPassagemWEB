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
 * Servlet implementation class AeronaveController
 */
@WebServlet("/comprarpassagem.do")
public class ComprarPassagemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ComprarPassagemController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String opcao = request.getParameter("opcao");
		RequestDispatcher view;
		HttpSession session = request.getSession();
		
		Passagem passagem = new Passagem();
		String mensagemResultado = "";
		switch(opcao)
		{		
			case "Pesquisar":
				String aeroOrigem = request.getParameter("AeroOrigem");
				String aeroDestino = request.getParameter("AeroDestino");
				String quantidade = request.getParameter("Quantidade");
				String impressaoPassagem = "";
				
				try
				{
					impressaoPassagem = passagem.buscarPassagem(aeroOrigem, aeroDestino, quantidade);
				}
				catch(Exception e)
				{
					mensagemResultado = e.getMessage();
				}
				
				session.setAttribute("quantidadePassageiros", quantidade);
				request.setAttribute("mensagemResultado", mensagemResultado);
				request.setAttribute("impressaoPassagem", impressaoPassagem);
				view = request.getRequestDispatcher("selecionarPassagem.jsp");
    			view.forward(request, response);
				break;
				
			case "Comprar":
				String CodigoVoo = request.getParameter("CodigoVoo");				
				session.setAttribute("CodigoVoo", CodigoVoo);
				view = request.getRequestDispatcher("passageiro.jsp");
    			view.forward(request, response);
				
				break;
			case "Cancelar":				
				response.setContentType("text/html");		
				response.sendRedirect("menu.html");
				break;
		}
	}

}
