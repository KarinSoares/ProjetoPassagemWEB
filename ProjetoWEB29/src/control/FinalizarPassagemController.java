package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pagamento;
import model.Passagem;

/**
 * Servlet implementation class AeronaveController
 */
@WebServlet("/passagem.do")
public class FinalizarPassagemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizarPassagemController() {
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
		HttpSession session = request.getSession();
		String opcao = request.getParameter("opcao");
		
		String codigo = request.getParameter("Codigo");
		String tipoCartao = request.getParameter("Cartao");
		String nome = request.getParameter("Nome");
		String cpf = request.getParameter("CPF");
		String nCartao = request.getParameter("NCartao");
		String dValidade = request.getParameter("DataValidade");
		String codSegurança = request.getParameter("CodSegurança");
		String banco = request.getParameter("Banco");
		String agencia = request.getParameter("Agencia");
		String contaCorrente = request.getParameter("ContaCorrente");
		String email = request.getParameter("Email");
		String telefone = request.getParameter("Telefone");
		
		String CodigoVoo = (String)session.getAttribute("CodigoVoo");
		String cliente = (String)session.getAttribute("clientes");
		
		String[] codigoClientes = cliente.split("-");
		
		Pagamento pagamento = new Pagamento();
		
		String mensagemResultado = "";
		switch(opcao)
		{		
			case "Finalizar":
				
				double valor = codigoClientes.length * 200.00;
				
				pagamento.setCodigo(Integer.parseInt(codigo));
				pagamento.setValor(valor);
				pagamento.setTipoCartao(tipoCartao);
				pagamento.setNomeTitular(nome);
				pagamento.setCpf(cpf);
				pagamento.setNumeroCartao(nCartao);
				pagamento.setDataValidade(dValidade);
				pagamento.setCodSeguranca(codSegurança);
				pagamento.setBanco(banco);
				pagamento.setAgencia(agencia);
				pagamento.setConta(contaCorrente);
				pagamento.setEmail(email);
				pagamento.setTelefone(telefone);
				
				mensagemResultado = "Passagem Cadastrada com sucesso";
				
				try
				{
					pagamento.incluir();
					
					Passagem passagem = new Passagem();
					passagem.setPagamento(pagamento);					
										
					passagem.incluir(
							pagamento.getCodigo(),
							codigoClientes,
							CodigoVoo == null ? 0: Integer.parseInt(CodigoVoo));
				}
				catch(Exception e)
				{
					mensagemResultado = e.getMessage();
				}
				
				request.setAttribute("mensagemResultado", mensagemResultado);
				response.setContentType("text/html");		
				response.sendRedirect("menu.html");
				
				break;
			case "Cancelar":		
				
				response.setContentType("text/html");		
				response.sendRedirect("menu.html");
				break;
		}
	}
}
