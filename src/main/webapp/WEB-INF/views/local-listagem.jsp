<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listagem de locais</title>
</head>
<body>
        <tr>
            <th>Nome</th>
            <th>Código</th>
            <th>Bairro</th>
            <th>Cidade</th>
            <th>Data de criação</th>
        </tr>
        <br />
    <c:forEach items="${locais}" var="local" varStatus="loop">
        <tr>
            <td>${local.nome}</td>
            <td>${local.codigo}</td>
            <td>${local.bairro}</td>
            <td>${local.cidade}</td>
            <td>${local.dataFormatada}</td>
            <a href="/local-editar?id=${loop.index+1}">Editar</a>
        </tr>
        <br />
    </c:forEach>
</body>
</html>