<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Fintech Bank - Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body>
<%@include file="header.jsp"%>

<div class="container mt-5">
    <!-- Seção principal -->
    <div class="jumbotron text-center">
        <h1 class="display-4">Bem-vindo ao Fintech Bank</h1>
        <p class="lead">Escolha uma das opções abaixo para começar a gerenciar suas finanças.</p>
        <hr class="my-4">
    </div>

    <!-- Opções bancárias -->
    <div class="row text-center">
        <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">PIX</h5>
                    <p class="card-text">Faça transferências instantâneas com PIX.</p>
                    <a href="pix.jsp" class="btn btn-primary">Acessar PIX</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Boleto</h5>
                    <p class="card-text">Emita ou pague boletos bancários.</p>
                    <a href="boleto.jsp" class="btn btn-primary">Acessar Boleto</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card mb-4 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Opções Gerais</h5>
                    <p class="card-text">Acesse outras opções do banco, como saldo.</p>
                    <a href="opcoes-gerais.jsp" class="btn btn-primary">Acessar Opções Gerais</a>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>
<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>
