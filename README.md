# Test project for BellIntegrator

Приложение (практическая работа) позволяет управлять данными организаций,
офисов а так же данными пользователей, которые работают в них.

## Примеры запросов:

### Получение организаций по параметрам

***Пример запроса***
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2018.23.18.png)

Запрос должен содержать объект JSON, используемый для поиска организаций:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2018.32.48.png)

Пример ответа от сервера, в результате ***успешного*** выполнения запроса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2018.36.28.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2018.45.11.png)

### Получение организации по идентификатору

***Пример запроса***
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2018.56.50.png)
Запрос должен содержать Id искомой организации, указывается в конце адреса запроса.

Пример ответа от сервера, в результате успешного выполнения запроса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2019.02.23.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2019.16.41.png)

