<%@page import="javax.swing.JOptionPane"%>
<%@ page import="java.util.*, java.text.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voo</title>
<link type="text/css" rel="stylesheet" href="./css/main.css" />
<link type="text/css" rel="stylesheet" href="./css/imagens.css" />

<script type="text/javascript">
	if("${mensagemResultado}" != "")
		alert("${mensagemResultado}");
</script>

</head>
<body>
	<form method="post" action="voo.do" class="centralizar">
		
		<label> Código</label> <input type="text" class="texto" name="CodigoPesquisa">	
		<input type="submit"   name="opcao" value="Consultar">
		
		<label> Código</label> <input type="number" class="texto" min="0" name="Codigo" id="Codigo" value="${Codigo}" readonly="true">
		<label> Origem</label> <input type="text" class="texto" name="Origem" id="Origem" value="${Origem}">
		<label> Destino</label> <input type="text" class="texto" name="Destino" id="Destino" value="${Destino}">
		<label> Data/Hora</label> <input type="text" class="texto" name="DataHora" id="DataHora" value="${DataHora}">
		<label> Cód. Aeronave</label> <input type="text" class="texto" name="CodAeronave" id="CodAeronave" value="${CodAeronave}">
		<label> Situação</label> <input type="text" class="texto" name="Situacao" id="Situacao" value="${Situacao}">
		
		<fieldset>
			<input type="submit"  class="botao" name="opcao" value="Cadastrar">
			<input type="submit"  class="botao" name="opcao" value="Alterar">
			<input type="submit"  class="botao" name="opcao" value="Excluir">
			<input type="submit"  class="botao" name="opcao" value="Voltar">
		</fieldset>		
		
	</form>

</body>
</html>