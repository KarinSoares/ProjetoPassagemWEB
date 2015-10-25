package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Voo;

/**
 * Servlet implementation class AeronaveController
 */
@WebServlet("/voo.do")
public class VooController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VooController() {
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
		String origem = request.getParameter("Origem");
		String destino = request.getParameter("Destino");
		String dataHora = request.getParameter("DataHora");
		String codAeronave = request.getParameter("CodAeronave");
		String situacao = request.getParameter("Situacao");	
		
		Voo voo = new Voo();
		String mensagemResultado = "";
		
		switch(opcao)
		{		
			case "Consultar":
				try
				{
					voo = voo.consultar(codigoPesquisa);
				}
				catch(Exception e)
				{
					mensagemResultado = e.getMessage();
				}
				
				if(mensagemResultado == "")
				{
					request.setAttribute("Codigo", voo.getCodVoo());
					request.setAttribute("Origem", voo.getAeroportoOrigem());
					request.setAttribute("Destino", voo.getAeroportoDestino());
					request.setAttribute("DataHora", voo.getDataHora());
					request.setAttribute("CodAeronave", voo.getAeronave());
					request.setAttribute("Situacao", voo.getSituacao());					
				}
				else
				{
					request.setAttribute("Codigo", "");
					request.setAttribute("Origem", "");
					request.setAttribute("Destino", "");
					request.setAttribute("DataHora", "");
					request.setAttribute("CodAeronave", "");
					request.setAttribute("Situacao", "");
					
				}
				
				request.setAttribute("mensagemResultado", mensagemResultado);				
				view = request.getRequestDispatcher("voo.jsp");
    			view.forward(request, response);
				break;
			case "Cadastrar":
				voo.setAeroportoOrigem(origem);
    			voo.setAeroportoDestino(destino);	        				        			
				try {
					if(dataHora != null && dataHora != "")
						voo.setDataHora(dataHora);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	        			
    			voo.setAeronave(Integer.parseInt(codAeronave));
    			voo.setSituacao(situacao);
				
				mensagemResultado = "Voo Cadastrado com sucesso";
				
				try
				{
					voo.incluir();
				}
				catch(Exception e)
				{
					mensagemResultado = e.getMessage();
				}
				
				request.setAttribute("mensagemResultado", mensagemResultado);
				view = request.getRequestDispatcher("voo.jsp");
    			view.forward(request, response);				
				
				break;
			case "Alterar":
				voo.setCodVoo(Integer.parseInt(codigo));
				voo.setAeroportoOrigem(origem);
    			voo.setAeroportoDestino(destino);	        				        			
				try {
					if(dataHora != null && dataHora != "")
						voo.setDataHora(dataHora);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	        			
    			voo.setAeronave(Integer.parseInt(codAeronave));
    			voo.setSituacao(situacao);
				mensagemResultado = "Voo alterado com sucesso";
				
				try
				{
					voo.alterar();
				}
				catch(Exception e)
				{
					mensagemResultado = e.getMessage();
				}
				
				request.setAttribute("mensagemResultado", mensagemResultado);
				view = request.getRequestDispatcher("voo.jsp");
    			view.forward(request, response);
				break;
			case "Excluir":
				voo.setCodVoo(Integer.parseInt(codigo));
				
				mensagemResultado = "Voo excluido com sucesso";
				
				try
				{
					voo.excluir();			
				}
				catch(Exception e)
				{
					mensagemResultado = e.getMessage();
				}
				
				request.setAttribute("mensagemResultado", mensagemResultado);
				
				view = request.getRequestDispatcher("voo.jsp");
    			view.forward(request, response);
				
				break;
			case "Voltar":
				response.setContentType("text/html");		
				response.sendRedirect("menu.html"); 
				break;
		}
	}

}
