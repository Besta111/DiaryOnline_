<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Авторизация</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container-fluid p-5 bg-success text-white text-center">
    <h1>Дневники Онлайн</h1>
    <p>Заведи свой дневник, сохрани важные воспоминания!</p>
</div>
<div class="bg-light p-3 text-center">
    <h2>Введите email и пароль:</h2>
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <form action="/signIn" method="post">
                <div class="mb-3 mt-3">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" class="form-control" id="email" placeholder="Ваш email" name="email">
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Пароль:</label>
                    <input type="password" class="form-control" id="password" placeholder="Ваш пароль" name="password">
                </div>
                <div class="form-check mb-3">
                    <label class="form-check-label">
                        <input class="form-check-input" type="checkbox" name="remember"> Remember me
                    </label>
                </div>
                <button type="submit" class="btn btn-success">Войти</button>
                <a href="/signUp"><button type="button" class="btn btn-success">Регистрация</button></a>
            </form>
        </div>
        <div class="col-sm-3"></div>
    </div>
</div>
</body>
</html>