<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="myPackage.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org.TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

<title>InsperNotes System</title>
</head>
<body class="bg-dark text-light mt-3" style="overflow-x: hidden !important">
<h3>Crie seu perfil ou faça Login</h3>
<form action="criauser" method="GET">
<input type="submit" value="Criar Perfil"></form>
<form action="login" method="GET">
<input type="submit" value="Fazer Login"></form>
</body>
</html>