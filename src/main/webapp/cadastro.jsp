<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Produtos</title>
</head>
<body>
	<h1>Cadastro de Produtos</h1>
	<form name="cadastro" action="ProdutoController" method="post">
							<input type="hidden" name="id" value="${produto.id}"><br>
		<label>Nome:</label><input type="text" name="nome" value="${produto.nome}"><br>
		<label>Valor:</label><input type="number" name="valor" value="${produto.valor}"><br>
		<label>&nbsp;</label><input type="submit" name="btCadastro" value="Cadastro">
	</form>
</body>
</html>