<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cadastro de Local</title>
</head>
<body>
    <form:form action="/local" method="post" modelAttribute="localDTO">
        <form:label path="nome">Nome:</form:label>
        <form:input path="nome" type="text" />

        <form:label path="codigo">Código:</form:label>
        <form:input path="codigo" type="text" />

        <form:label path="bairro">Bairro:</form:label>
        <form:input path="bairro" type="text" />

        <form:label path="cidade">Cidade:</form:label>
        <form:input path="cidade" type="text" />

        <form:label path="dataCriacao">Data de criação:</form:label>
        <form:input path="dataCriacao" type="text" />

        <input value="Adicionar" type="submit" />
    </form:form>
</body>
</html>
