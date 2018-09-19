<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<body class="bg-dark text-light mt-3" style="overflow-x: hidden !important">
	<%DAO dao = new DAO();%>
  <div class="row container">
    <div class="col">
    	<h4 class="m-2 p-1">Olá, <%=request.getAttribute("Username")%>, este é o seu Painel de Notas</h4>
    </div>   
  </div>
  <div class="row container">
	<div class=col><p class="m-2 p-1">Crie, edite e remova suas notas. Organizar suas atividades e lembretes nunca foi tão simples!</p></div>
  </div>	
  
  <div class="input-group mt-5">

    <div class="card mt-4 mb-2 ml-4 mr-4 p-1 text-dark" style="width: 17rem; min-height: 15rem;">
    	<div class="card-body">
       	<form action="crianota" method='POST'>
    	<input type="number" name="user_id" value="<%=request.getAttribute("userId")%>" style="display: none">
    	<input type="text" name="username" value="<%=request.getAttribute("Username")%>" style="display: none">
    	<h5 class="card-title"><input type='text' name='title' placeholder="Titulo da Nota" style="width: 100%;" class="rounded border-0"></h5>
    	<p class="card-text"><textarea rows='4' name='content' placeholder="Corpo da Nota" style="width: 100%; heigh: 100%; resize: none" class="rounded border-0"></textarea></p>
    	<button type='submit' class="btn btn-success btn-sm rounded text-loght"><i class="fas fa-check"></i></button></form>
    	</div>
	</div>

	<% List<Notas> notas = dao.getListaNotas((Integer)request.getAttribute("userId"));
	for (Notas nota : notas){
	%>
		<div class="card mt-4 mb-2 ml-4 mr-4 p-1 text-dark" style="width: 17rem; min-height: 15rem;">
  			<div class="card-body">
					<div class="input-group btn-group align-bottom" role="group">
						<form action='atualizanota' method='POST'>
						<input type="text" name="id" value="<%=nota.getId()%>" style="display: none">
    					<input type="text" name="username" value="<%=request.getAttribute("Username")%>" style="display: none">
    					<input type="text" name="user_id" value="<%=request.getAttribute("userId")%>" style="display: none">
			    		<h5 class="card-title"><input type='text' name='title' style="width: 100%;" class="rounded border-0" value="<%=nota.getTitle()%>" autocomplete="off"></h5>
    					<h5 class="card-text"><textarea rows='4' name='content' style="width: 100%; heigh: 100%; resize: none" class="rounded border-0" autocomplete="off"><%=nota.getContent()%></textarea></p>
						<button type='submit' class="bg-light btn btn-outline-warning btn-sm btn-secondary rounded border border-warning text-warning m-1"><i class="far fa-edit"></i></button></form>
	
						<input type="text" name="id" value="<%=nota.getId()%>" style="display: none">
    					<input type="text" name="username" value="<%=request.getAttribute("Username")%>" style="display: none">
    					<input type="text" name="user_id" value="<%=request.getAttribute("userId")%>" style="display: none">
						<button type='submit' formaction='removenota' class="bg-light btn btn-outlinr-danger btn-sm btn-secondary rounded border border-danger text-danger m-1"><i class="far fa-trash-alt"></i></button></form>
 					</div>
  			</div>
		</div>
		<% } %>
  </div>

</body>
</html>