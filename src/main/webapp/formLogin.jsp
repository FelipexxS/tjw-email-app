<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<link rel="stylesheet" href="Main.css">
</head>
<body>
	<header>
		<h1 id="title">Sign In and Mail!</h1>
	</header>
	<form id="loginForm" method="post" action="MailAuth">
		<div class="input-group">
			<label for="user">Nome de Usuário:</label>
			<input type="text"  id="user" name="userName" placeholder="Digite seu nome de usuário...">
		</div>
		<div class="input-group">
			<label for="password">Senha:</label>
			<input type="password" id="password" name="userPassword" placeholder="Digite sua senha...">
		</div>
		<button type="submit">Entrar</button>
	</form>
</body>

</html>