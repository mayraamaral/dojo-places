<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Listagem de locais</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"
    />
</head>
<body>

        <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="staticBackdropLabel">Deletar local</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        Você deseja realmente deletar este local?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                        <form method="post" action="local-deletar?id=${local.id}">
                            <button type="submit" class="btn btn-primary">Confirmar exclusão</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

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
                    <th scope="col">Id</th>
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
                    <td class="align-middle">${local.id}</td>
                    <td class="align-middle">${local.nome}</td>
                    <td class="align-middle">${local.codigo}</td>
                    <td class="align-middle">${local.bairro}</td>
                    <td class="align-middle">${local.cidade}</td>
                    <td class="align-middle">${local.dataCriacaoFormatada}</td>
                    <td class="align-middle">${local.diasDesdeAtualizacaoFormatadoOuStringVazia}</td>
                    <td class="d-flex align-middle gap-1">
                        <a href="/local-editar?id=${local.id}" class="btn btn-primary h-50">Editar</a>
                        <button type="button" class="btn btn-danger" onclick="confirmDelete(${local.id})">Deletar</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <script src="/assets/js/local-listagem.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous">
    </script>
</body>
</html>