<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listagem de locais</title>
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
    <c:if test="${foiAdicionadoLocal}">
        <div class="d-flex justify-content-end pt-4 px-4">
            <div class="alert alert-success col-md-2" role="alert" >
                Local adicionado com sucesso!
            </div>
        </div>
    </c:if>

    <c:if test="${foiDeletadoLocal}">
        <div class="d-flex justify-content-end pt-4 px-4">
            <div class="alert alert-danger col-md-2" role="alert" >
                Local deletado com sucesso!
            </div>
        </div>
    </c:if>

    <div class="container">
        <h1 class="text-center py-3">Listagem de locais</h1>
        <div class="d-flex justify-content-start pb-3">
            <a href="/local-adicionar" class="btn btn-primary">Adicionar</a>
        </div>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">Código</th>
                    <th scope="col">Bairro</th>
                    <th scope="col">Cidade</th>
                    <th scope="col">Data de criação</th>
                    <th scope="col">Data de atualização</th>
                    <th scope="col">Ações</th>
                </tr>
            </thead>
            <c:forEach items="${locais}" var="local" varStatus="loop">
                <tr>
                    <td class="align-middle">${local.nome}</td>
                    <td class="align-middle">${local.codigo}</td>
                    <td class="align-middle">${local.bairro}</td>
                    <td class="align-middle">${local.cidade}</td>
                    <td class="align-middle">${local.dataCriacaoFormatada}</td>
                    <td class="align-middle">${local.diasDesdeAtualizacaoFormatadoOuStringVazia}</td>
                    <td class="align-middle">
                        <a href="/local-editar?id=${local.id}" class="btn btn-primary">Editar</a>
                        <a href="/local-deletar?id=${local.id}" class="btn btn-danger">Deletar</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>