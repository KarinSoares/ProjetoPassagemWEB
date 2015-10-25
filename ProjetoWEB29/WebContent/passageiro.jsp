<%@page import="javax.swing.JOptionPane"%>
<%@ page import="java.util.*, java.text.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Passageiros</title>
<link type="text/css" rel="stylesheet" href="./css/main.css" />
<link type="text/css" rel="stylesheet" href="./css/imagens.css" />

</head>
<body>
	<form method="post" action="passageiro.do" class="centralizar">
	
		<label> Codigo</label> <input type="text" class="texto" name="Codigo" id="Codigo" value="${Codigo}">
		<label> Tipo de Passageiro</label> <input type="text" class="texto" name="TipoPassageiro" id="TipoPassageiro" value="${TipoPassageiro}">
		<label> Tratamento</label> <input type="text" class="texto" name="Tratamento" id="Tratamento" value="${Tratamento}">
		<label> Nome</label> <input type="text" class="texto" name="Nome" id="Nome" value="${Nome}">
		<label> Sobrenome</label> <input type="text" class="texto" name="Sobrenome" id="Sobrenome" value="${Sobrenome}">
		<label> Data de Nascimento</label> <input type="text" class="texto" name="DataNascimento" id="DataNascimento" value="${DataNascimento}">
		
		<fieldset>
			<input type="submit"  class="botao" name="opcao" value="Cadastrar">
			<input type="submit"  class="botao" name="opcao" value="Prosseguir">
			<input type="submit"   name="opcao" value="Cancelar">
		</fieldset>	
	
	</form>

</body>
</html>