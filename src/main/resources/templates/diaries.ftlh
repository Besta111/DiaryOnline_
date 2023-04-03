<html>
<head>
    <meta charset="UTF-8">
    <title>Accounts</title>
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
    <h2>Все дневники:</h2>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <table id="accounts_table" class="table table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Название дневника</th>
                    <th>Действие</th>
                </tr>
                </thead>
                <tbody>
                <#list diaries as diary>
                    <tr>
                        <td>${diary.id}</td>
                        <td>${diary.name}</td>
                        <td>
                            <form method="get" action="/diaries/${diary.id}">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                <input type="submit" value="Посмотреть">
                            </form>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="col-sm-4"></div>
    </div>
</div>

</body>
</html>
