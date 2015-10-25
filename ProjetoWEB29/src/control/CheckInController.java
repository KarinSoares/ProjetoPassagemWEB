package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Passagem;

/**
 * Servlet implementation class AeronaveController
 */
@WebServlet("/checkin.do")
public class CheckInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckInController() {
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
		
		String bilhete = request.getParameter("Bilhete");
		String nrAssento = request.getParameter("NrAssento");
		
		Passagem pas = new Passagem();
		String mensagemResultado = "";
				
		switch(opcao)
		{		
			case "Consultar":
				
				try
				{
					if(bilhete == null || bilhete == "" || Integer.parseInt(bilhete) <= 0)
						throw new Exception("Informe número do bilhete");
						
					pas.setCodigo(Integer.parseInt(bilhete));
					pas.consultarCheckIn();
					
				}
				catch(Exception e)
				{
					mensagemResultado = e.getMessage();
				}
				
				if(mensagemResultado == "")
				{
					request.setAttribute("Nome", pas.getCliente().getNome());
					request.setAttribute("Sobrenome", pas.getCliente().getSobrenome());
				}
				else
				{
					request.setAttribute("Nome", "");
					request.setAttribute("Sobrenome", "");
				}
				
				request.setAttribute("mensagemResultado", mensagemResultado);				
				view = request.getRequestDispatcher("check_in.jsp");
    			view.forward(request, response);
				break;
			case "Confirmar":
				mensagemResultado = "Check-in realizado com sucesso";
				
				try
				{
					pas.alterarAssento(bilhete,nrAssento );
				}
				catch(Exception e)
				{
					mensagemResultado = e.getMessage();
				}
				
				request.setAttribute("Nome", "");
				request.setAttribute("mensagemResultado", mensagemResultado);				
				view = request.getRequestDispatcher("check_in.jsp");
    			view.forward(request, response);
				
				break;			
			case "Voltar":
				response.setContentType("text/html");		
				response.sendRedirect("menu.html"); 
				break;
		}
	}

}
