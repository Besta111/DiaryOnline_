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
    <h2>${name}</h2>
    <h2>Все записи:</h2>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <table id="accounts_table" class="table table-bordered">
                <thead>
                <tr>
                    <th>Запись</th>
                </tr>
                </thead>
                <tbody>
                <#list records as record>
                    <tr>
                        <td>${record.name}</td>
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
