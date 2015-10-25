<%@page import="javax.swing.JOptionPane"%>
<%@ page import="java.util.*, java.text.*"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comprar Passagem</title>
<link type="text/css" rel="stylesheet" href="./css/main.css" />
<link type="text/css" rel="stylesheet" href="./css/imagens.css" />

<script type="text/javascript">
	if("${mensagemResultado}" != "")
		alert("${mensagemResultado}");
</script>

</head>
<body>
	<form method="post" action="comprarpassagem.do" class="centralizar">
		
		<label> Aeroporto Origem</label> <input type="text" name="AeroOrigem" id="AeroOrigem" value="${AeroOrigem}">
		<label> Aeroporto Destino</label> <input type="text" name="AeroDestino" id="AeroDestino" value="${AeroDestino}">
		<label> Quantidade</label> <input type="text" name="Quantidade" id="Quantidade" value="${Quantidade}">
		
		<fieldset>
			<input type="submit"  name="opcao" value="Pesquisar">
			<input type="submit"  name="opcao" value="Cancelar">
		</fieldset>		
		
	</form>
</body>
</html>