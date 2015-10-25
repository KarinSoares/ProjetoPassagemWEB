<%@page import="javax.swing.JOptionPane"%>
<%@ page import="java.util.*, java.text.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passagem</title>
<link type="text/css" rel="stylesheet" href="./css/main.css" />
<link type="text/css" rel="stylesheet" href="./css/imagens.css" />
</head>
<body>

	<form method="post" action="passagem.do" class="centralizar">
		
		<label> Codigo</label> <input type="text" class="texto" name="Codigo" id="Codigo" value="${Codigo}">
		<label> Tipo de Cartão</label> <input type="text" class="texto" name="Cartao" id="Cartao" value="${Cartao}">
		<label> Nome do Titular</label> <input type="text" class="texto" name="Nome" id="Nome" value="${Nome}">
		<label> CPF</label> <input type="text" class="texto" name="CPF" id="CPF" value="${CPF}">
		<label> Número do Cartão</label> <input type="text" class="texto" name="NCartao" id="NCartao" value="${NCartao}">
		<label> Data de Validade</label> <input type="text" class="texto" name="DataValidade" id="DataValidade" value="${DataValidade}">
		<label> Código de Segurança</label> <input type="text" class="texto" name="CodSegurança" id="CodSegurança" value="${CodSegurança}">
		<label> Banco</label> <input type="text" class="texto" name="Banco" id="Banco" value="${Banco}">
		<label> Agência</label> <input type="text" class="texto" name="Agencia" id="Agencia" value="${Agencia}">
		<label> Conta Corrente</label> <input type="text" class="texto" name="ContaCorrente" id="ContaCorrente" value="${ContaCorrente}">
		<label> E-mail</label> <input type="text" class="texto" name="Email" id="Email" value="${Email}">
		<label> Telefone</label> <input type="text" class="texto" name="Telefone" id="Telefone" value="${Telefone}">
	
		<fieldset>
			<input type="submit"  class="botao" name="opcao" value="Finalizar">
			<input type="submit"  class="botao" name="opcao" value="Cancelar">
		</fieldset>		
		
	</form>

</body>
</html>