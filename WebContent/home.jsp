<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="myPackage.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org.TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Painel de Notas</title>
</head>
<body>
	<h2>Bem vindo(a) ao seu Painel de Notas</h2>
	
	
	<div class='container-inline'>
	<form action="crianota">
	<input type='submit' value='Criar Nota' class='btn btn-success btn-sm'></form>
	
	<form action='atualizanota'>
	<input type='submit' value='Editar Nota' class="btn btn-warning btn-sm"></form>
	
	<form action='removenota'>
	<input type='submit' value='Remover Nota' class="btn btn-danger btn-sm"></form>
	</div>
	
	<table border='1'>
	<% DAO dao = new DAO();
	List<Notas> notas = dao.getListaNotas();
	for (Notas nota : notas) { %>
	<tr>
	<td><%=nota.getTitle()%></td>
	<td><%=nota.getContent()%></td>
	</tr>
		<% } %>
		</table>

</body>
</html>