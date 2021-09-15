<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
.container {
	text-align: center
}

.table {
	margin-left: auto;
	margin-right: auto;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>ComprarProdutos</title>
</head>
<body>
	<div class="container">
		<h2>Produtos</h2>
		<a href="ProdutoController?app=cadastro">Cadastrar Produtos</a>
		<table class="table" border=1>
			<thead>
				<tr>
					<th>Nome do Produto</th>
					<th>Valor</th>
					<th colspan="2">Carrinho</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtos}" var="produto">
					<tr>
						<td><c:out value="${produto.nome}"></c:out></td>
						<td>R$ <c:out value="${produto.valor}"></c:out></td>
						<td><a
							href="ProdutoController?app=adicionar&produtoId=<c:out value="${produto.id}"/>">Adicionar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h2>Carrinho</h2>
		<table class="table" border=1>
			<thead>
				<tr>
					<th>Produto</th>
					<th>Valor</th>
					<th>Quantidade</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtos}" var="produto">
					<tr>
						<td><c:out value="${produto.nome}"></c:out></td>
						<td>R$ <c:out value="${produto.valor}"></c:out></td>
						<td><c:out value="${produto.quantidade}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form>
			<input type="button" value="Comprar"
				onClick="alert('Compra realizada com sucesso!'); return true">
		</form>
	</div>
</body>
</html>