<%@page import="javax.swing.JOptionPane"%>
<%@ page import="java.util.*, java.text.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aeronave</title>
<link type="text/css" rel="stylesheet" href="./css/main.css" />
<link type="text/css" rel="stylesheet" href="./css/imagens.css" />

<script type="text/javascript">
	if("${mensagemResultado}" != "")
		alert("${mensagemResultado}");
</script>

</head>
<body>
	<form method="post" action="aeronave.do" class="centralizar">
		<label> Código</label> <input type="number" class="texto" min="0" name="CodigoPesquisa">	
		<input type="submit"  name="opcao" value="Consultar">
		
		<label> Código</label> <input type="number" class="texto" min="0" name="Codigo" id="Codigo" value="${Codigo}" readonly="true">
		<label> Nome</label> <input type="text" class="texto" name="NomeAero" id="NomeAero" value="${NomeAero}">
		<label> Quantidade</label> <input type="text" class="texto" name="Quantidade" pattern="[0-9]+$" value="${Quantidade}">
		<label> Localização</label> <input type="text" class="texto" name="Localizacao" value="${Localizacao}">
		
		<fieldset>
			<input type="submit"  class="botao" name="opcao" value="Cadastrar">
			<input type="submit"  class="botao" name="opcao" value="Alterar">
			<input type="submit"  class="botao" name="opcao" value="Excluir">
			<input type="submit"  class="botao" name="opcao" value="Voltar">
		</fieldset>
	</form>
</body>
</html>