package control;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Reembolso;

/**
 * Servlet implementation class CancelarPassagemControler
 */
@WebServlet(description = "/cancelarpassagem.do", urlPatterns = { "/cancelarpassagem.do" })
public class CancelarPassagemControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelarPassagemControler() {
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
		
		String numeroPassagem = request.getParameter("NumeroPassagem");
		String banco = request.getParameter("Banco");
		String agencia = request.getParameter("Agencia");
		String contaCorrente = request.getParameter("ContaCorrente");
		String nomeTitular = request.getParameter("NomeTitular");
		String cpf = request.getParameter("CPF");
		String valorReembolso = request.getParameter("ValorReembolso");
		
		Reembolso pas = new Reembolso();
		String mensagemResultado = "";


		
		switch(opcao)
		{		
			case "Voltar":
				response.setContentType("text/html");		
				response.sendRedirect("menu.html"); 
				break;
			case "Confirmar":		
				mensagemResultado = "Cancelamento realizado com sucesso";
				
				try
				{
					System.out.println("ENtrará no metodo :"+numeroPassagem + banco+ agencia+ contaCorrente+ nomeTitular+ cpf+ valorReembolso + getDateTime()+mensagemResultado );
					pas.cancelarPassagem( numeroPassagem , banco, agencia, contaCorrente, nomeTitular, cpf, valorReembolso , getDateTime() );
					
					System.out.println("Saiu do metodo : :"+numeroPassagem + banco+ agencia+ contaCorrente+ nomeTitular+ cpf+ valorReembolso + getDateTime()+mensagemResultado );
				}
				catch(Exception e)
				{System.out.println("Entrou na Exception : :"+numeroPassagem + banco+ agencia+ contaCorrente+ nomeTitular+ cpf+ valorReembolso + getDateTime()+mensagemResultado );
					mensagemResultado = e.getMessage();
					System.out.println("Entrou na Exception1 ::"+numeroPassagem + banco+ agencia+ contaCorrente+ nomeTitular+ cpf+ valorReembolso + getDateTime()+mensagemResultado );
				}
				
				request.setAttribute("mensagemResultado", mensagemResultado);				
				view = request.getRequestDispatcher("cancelar_passagem.jsp");
    			view.forward(request, response);
				
				break;	
		}
		
	}

	private String getDateTime() { 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Date date = new Date(); 
		return dateFormat.format(date); 
		}


	
	
	
}
