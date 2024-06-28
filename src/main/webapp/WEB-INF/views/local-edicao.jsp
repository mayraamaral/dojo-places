<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edição de local</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous">
    </script>
</head>
<body>
    <div class="container-sm">
        <h1 class="text-center py-3">Edição de locais</h1>
        <div class="d-flex justify-content-center">
            <form:form action="/local-editar?id=${localEditDTO.id}" method="post" modelAttribute="localEditDTO">
                <form:label path="nome" class="form-label">Nome:</form:label>
                <form:input path="nome" type="text" class="form-control" />
                <form:errors path="nome" cssClass="text-danger d-block" />

                <form:label path="codigo" class="form-label">Código:</form:label>
                <form:input path="codigo" type="text" class="form-control" />
                <form:errors path="codigo" cssClass="text-danger d-block" />

                <form:label path="bairro" class="form-label">Bairro:</form:label>
                <form:input path="bairro" type="text" class="form-control" />
                <form:errors path="bairro" cssClass="text-danger d-block" />

                <form:label path="cidade" class="form-label">Cidade:</form:label>
                <form:input path="cidade" type="text" class="form-control" />
                <form:errors path="cidade" cssClass="text-danger d-block" />

                <input id="id" name="id" type="hidden">

                <div class="pt-3 d-flex justify-content-center">
                    <button type="submit" class="btn btn-primary">Editar</button>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>
