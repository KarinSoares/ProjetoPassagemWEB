<%@page import="javax.swing.JOptionPane"%>
<%@ page import="java.util.*, java.text.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancelar Passagem</title>
<link type="text/css" rel="stylesheet" href="./css/main.css" />
<link type="text/css" rel="stylesheet" href="./css/imagens.css" />

<script type="text/javascript">
	if("${mensagemResultado}" != "")
		alert("${mensagemResultado}");
</script>

</head>
<body>
	<form method="post" action="cancelarpassagem.do" class="centralizar">
		
		
		<label> Número da Passagem</label> 	<input type="number" min ="0" 	class="texto" name="NumeroPassagem"	id="NumeroPassagem"	value="${NumeroPassagem}">
		<label> Banco</label> 				<input type="text" 				class="texto" name="Banco"			id="Banco"			value="${Banco}">
		<label> Agência</label> 			<input type="text" 				class="texto" name="Agencia"			id="Agencia"		value="${Agencia}">
		<label> Conta Corrente</label> 		<input type="text" 				class="texto" name="ContaCorrente"	id="ContaCorrente"	value="${ContaCorrente}">
		<label> Nome do Titular</label> 	<input type="text" 				class="texto" name="NomeTitular"		id="NomeTitular"	value="${NomeTitular}">
		<label> CPF</label> 				<input type="text" 				class="texto" name="CPF"				id="CPF"			value="${CPF}">
		<label> Valor Reembolso</label> 	<input type="text" 				class="texto" name="ValorReembolso"	id="ValorReembolso"	value="${ValorReembolso}">

		<fieldset>
			<input type="submit"  class="botao" name="opcao" value="Confirmar">
			<input type="submit"  class="botao" name="opcao" value="Voltar">
		</fieldset>		
		
	</form>

</body>
</html>