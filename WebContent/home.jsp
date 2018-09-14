<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="myPackage.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org.TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

<title>Painel de Notas</title>
</head>
<body class="bg-dark text-light mt-3">

  <div class="row">
    <div class="col">
    	<h4 class="m-2 p-1">Bem vindo(a) ao seu Painel de Notas</h4>
    </div>   
  </div>
  <div class="row">
	<div class=col-10><p class="m-2 p-1">Crie, edite e remova suas notas. Organizar suas atividades e lembretes nunca foi tão simples!</p></div>
    <div class="col-2">
    	<form action="crianota" method='GET'>
		<button type='submit' class="btn btn-success btn-lg rounded text-loght"><i class="fas fa-plus"></i></button></form>
    </div> 
  </div>	
  
  <div class="input-group mt-5">
	<% DAO dao = new DAO();
	List<Notas> notas = dao.getListaNotas();
	for (Notas nota : notas) { %>
		<div class="card mt-4 mb-2 ml-4 mr-4 p-1 text-dark" style="width: 17rem;">
  			<div class="card-body">
    			<h5 class="card-title"><%=nota.getTitle()%></h5>
    			<p class="card-text"><%=nota.getContent()%></p>
					<div class="input-group btn-group" role="group">
						<form action='atualizanota' method='GET'>
						<button type='submit' class="bg-light btn btn-outline-warning btn-sm btn-secondary rounded border border-warning text-warning m-1"><i class="far fa-edit"></i></button></form>
	
						<form action='removenota'>
						<button type='submit' class="bg-light btn btn-outlinr-danger btn-sm btn-secondary rounded border border-danger text-danger m-1"><i class="far fa-trash-alt"></i></button></form>
 					</div>
  			</div>
		</div>
		<% } %>

  </div>

</body>
</html>