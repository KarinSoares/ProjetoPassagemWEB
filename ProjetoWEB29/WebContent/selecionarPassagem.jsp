<%@page import="javax.swing.JOptionPane"%>
<%@ page import="java.util.*, java.text.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passagens</title>
<link type="text/css" rel="stylesheet" href="./css/main.css" />
<link type="text/css" rel="stylesheet" href="./css/imagens.css" />

</head>
<body>
	<form method="post" action="comprarpassagem.do" class="centralizar">
		
		<p>"${impressaoPassagem}"</p>
		
		<label> Código Passagem</label> <input type="number" class="texto" min="0" name="Codigo">	
		<br>
		<fieldset>
		<input type="submit"   class="botao" name="opcao" value="Comprar">
		<input type="submit"   class="botao" name="opcao" value="Cancelar">
		</fieldset>
		
	</form>
</body>
</html>