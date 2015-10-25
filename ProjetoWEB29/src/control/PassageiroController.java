package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;

/**
 * Servlet implementation class AeronaveController
 */
@WebServlet("/passageiro.do")
public class PassageiroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassageiroController() {
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
		
		String codigo = request.getParameter("Codigo");
		String tipoPassageiro = request.getParameter("TipoPassageiro");
		String tratamento = request.getParameter("Tratamento");
		String nome = request.getParameter("Nome");
		String sobrenome = request.getParameter("Sobrenome");
		String dNascimento = request.getParameter("DataNascimento");
		
		Cliente cliente = new Cliente();
		String mensagemResultado = "";

		switch(opcao)
		{		
			case "Cadastrar":
				cliente.setCodigo(Integer.parseInt(codigo));
				cliente.setTipoCliente(tipoPassageiro);
				cliente.setTratamento(tratamento);
				cliente.setNome(nome);
				cliente.setSobrenome(sobrenome);
				cliente.setDataNascimento(dNascimento);
				
				mensagemResultado = "Cliente Cadastrada com sucesso";
				
				try
				{
					cliente.incluir();
					session.setAttribute("clientes", cliente.getCodigo() + "-");
				}
				catch(Exception e)
				{
					mensagemResultado = e.getMessage();
				}
				
				request.setAttribute("mensagemResultado", mensagemResultado);
				view = request.getRequestDispatcher("passageiro.jsp");
    			view.forward(request, response);
				
				break;
			case "Prosseguir":
				view = request.getRequestDispatcher("passagem.jsp");
    			view.forward(request, response);
				
				break;

			case "Cancelar":		
				
				response.setContentType("text/html");		
				response.sendRedirect("menu.html");
				
				break;
		}
	}

}
