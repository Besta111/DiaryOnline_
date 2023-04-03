<!DOCTYPE html>
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <title><@spring.message 'signUp.page.title'/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="container-fluid p-5 bg-success text-white text-center">
    <h1>Дневники Онлайн</h1>
    <p>Заведи свой дневник, сохрани важные воспоминания!</p>
</div>
<div class="bg-light p-3">
    <h2 style="text-align: center;">Регистрация</h2>
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <form action="/signUp" method="post">
                <div class="mb-3 mt-3">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <@spring.bind path="signUpForm"/>
                    <p class="error">${spring.status.errorMessage}</p>
                    <label for="username" class="form-label">Username:</label>
                    <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.username"/></#assign>
                    <@spring.formInput "signUpForm.username" "placeholder=${i18Tooltip}"/>
                    <@spring.showErrors "<br>" "error"/>
                </div>

                <div class="mb-3">
                    <label for="email"><@spring.message 'signUp.form.label.email'/></label>
                    <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.email"/></#assign>
                    <@spring.formInput "signUpForm.email" "placeholder=${i18Tooltip}"/>
                    <@spring.showErrors "<br>" "error"/>
                </div>
                <div class="mb-3">
                    <label for="password">Пароль</label>
                    <#assign i18Tooltip><@spring.message code="signUp.form.placeholder.password"/></#assign>
                    <@spring.formPasswordInput "signUpForm.password" "placeholder=${i18Tooltip}"/>
                    <@spring.showErrors "<br>" "error"/>
                </div>
                <button type="submit" class="btn btn-success">Зарегистрироваться</button>
            </form>
        </div>
        <div class="col-sm-3"></div>
    </div>
</div>
</body>
</html>