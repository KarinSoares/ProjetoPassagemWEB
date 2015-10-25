<%@page import="javax.swing.JOptionPane"%>
<%@ page import="java.util.*, java.text.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check - in</title>
<link type="text/css" rel="stylesheet" href="./css/main.css" />
<link type="text/css" rel="stylesheet" href="./css/imagens.css" />

<script type="text/javascript">
	if("${mensagemResultado}" != "")
		alert("${mensagemResultado}");
</script>

</head>
<body>
	<form method="post" action="checkin.do" class="centralizar">
		
		<label> Bilhete</label> <input type="text" class="texto" name="Bilhete" id="Bilhete" value="${Bilhete}" >	
		<input type="submit"  name="opcao" value="Consultar">
		
		<label> Nome</label> <input type="text" class="texto" name="Nome" id="Nome" value="${Nome}" readonly="true">
		<label> Sobrenome</label> <input type="text" class="texto" name="Sobrenome" id="Sobrenome" value="${Sobrenome}" readonly="true">
		<label> Número Assento</label> <input type="text" class="texto" name="NrAssento" id="NrAssento" value="${NrAssento}">
		
		<fieldset>
			<input type="submit"  class="botao" name="opcao" value="Confirmar">
			<input type="submit"  class="botao" name="opcao" value="Voltar">
		</fieldset>				
	</form>
</body>
</html>