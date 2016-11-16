<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/jquery-1.11.1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
    function finalizaAgora(id) {
    	
      $.post("finalizaTarefa", {'id' : id}, function() {
    	  alert("teste3");
        // selecionando o elemento html através da 
        // ID e alterando o HTML dele 
       
        alert("teste3");
      });
    }
  </script>
	<a href="novaTarefa">Criar nova tarefa</a>

	<br />
	<br />

	<table border="1px;">
		<tr>
			<th>Id</th>
			<th>Descrição</th>
			<th>Finalizado?</th>
			<th>Data de finalização</th>
		</tr>
		<c:forEach items="${tarefas}" var="tarefa">
			<tr>
				<td id="id">${tarefa.id}</td>
				<td id="desc">${tarefa.descricao}</td>
				<c:if test="${tarefa.finalizado eq false}">
					<td id="tarefa_${tarefa.id}"><a href="#"
						onClick="finalizaAgora(${tarefa.id})"> Finaliza agora! </a></td>
				</c:if>
				<c:if test="${tarefa.finalizado eq true}">
					<td>Finalizado</td>
				</c:if>
				<td id="data"><fmt:formatDate
						value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" /></td>
				<td id="btalterar"><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
				<td id="btremover"><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>