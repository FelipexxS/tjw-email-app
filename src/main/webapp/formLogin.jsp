<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<body>
	<header>
		<h1>Sign In and Mail!</h1>
	</header>
	<form id="loginForm" method="post" action="PagMail">
		<label for="user">Nome de Usuário:</label>
		<input type="text"  id="user" name="userName" placeholder="Digite seu nome de usuário...">
		<label for="password">Senha:</label>
		<input type="text" id="password" name="userPassword" placeholder="Digite sua senha...">
		<button type="submit">Entrar</button>
	</form>
</body>
</html>