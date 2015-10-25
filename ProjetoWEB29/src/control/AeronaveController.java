package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aeronave;

/**
 * Servlet implementation class AeronaveController
 */
@WebServlet("/aeronave.do")
public class AeronaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AeronaveController() {
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
		
		String codigoPesquisa = request.getParameter("CodigoPesquisa");
		String codigo = request.getParameter("Codigo");
		String nome = request.getParameter("NomeAero");
		String quantidade = request.getParameter("Quantidade");
		String localizacao = request.getParameter("Localizacao");
		
		Aeronave aeronave = new Aeronave();
		String mensagemResultado = "";
				
		switch(opcao)
		{		
			case "Consultar":
				try
				{
					aeronave = aeronave.consultarAeronave(codigoPesquisa);
				}
				catch(Exception e)
				{
					mensagemResultado = e.getMessage();
				}
				
				if(mensagemResultado == "")
				{
					request.setAttribute("Codigo", aeronave.getCodAeronave());
					request.setAttribute("NomeAero", aeronave.getNmAeronave());
					request.setAttribute("Quantidade", aeronave.getQtdeAssAeronave());
					request.setAttribute("Localizacao", aeronave.getLocalizacaoAssento());
				}
				else
				{
					request.setAttribute("Codigo", "");
					request.setAttribute("NomeAero", "");
					request.setAttribute("Quantidade", "");
					request.setAttribute("Localizacao", "");
				}
				
				request.setAttribute("mensagemResultado", mensagemResultado);				
				view = request.getRequestDispatcher("aeronave.jsp");
    			view.forward(request, response);
				break;
			case "Cadastrar":				
				aeronave.setNmAeronave(nome);
				aeronave.setQtdeAssAeronave(Integer.parseInt(quantidade));
				aeronave.setLocalizacaoAssento(localizacao);
				
				mensagemResultado = "Aeronave Cadastrada com sucesso";
				
				try
				{
					aeronave.incluir();
				}
				catch(Exception e)
				{
					mensagemResultado = e.getMessage();
				}
				
				request.setAttribute("mensagemResultado", mensagemResultado);
				view = request.getRequestDispatcher("aeronave.jsp");
    			view.forward(request, response);
				
				break;
			case "Alterar":
				aeronave.setCodAeronave(Integer.parseInt(codigo));
				aeronave.setNmAeronave(nome);
				aeronave.setQtdeAssAeronave(Integer.parseInt(quantidade));
				aeronave.setLocalizacaoAssento(localizacao);
				
				mensagemResultado = "Aeronave alterada com sucesso";
				
				try
				{
					aeronave.alterar();
				}
				catch(Exception e)
				{
					mensagemResultado = e.getMessage();
				}
				
				request.setAttribute("mensagemResultado", mensagemResultado);
				view = request.getRequestDispatcher("aeronave.jsp");
    			view.forward(request, response);
				break;
				
			case "Excluir":
				aeronave.setCodAeronave(Integer.parseInt(codigo));
				
				mensagemResultado = "Aeronave excluida com sucesso";
				
				try
				{
					aeronave.excluir();			
				}
				catch(Exception e)
				{
					mensagemResultado = e.getMessage();
				}
				
				request.setAttribute("mensagemResultado", mensagemResultado);
				
				view = request.getRequestDispatcher("aeronave.jsp");
    			view.forward(request, response);
				break;
			case "Voltar":
				response.setContentType("text/html");		
				response.sendRedirect("menu.html"); 
				break;
		}
	}

}
