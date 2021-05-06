# Test project for BellIntegrator

Приложение (практическая работа) позволяет управлять данными организаций,
офисов а так же данными пользователей, которые работают в них.

## Примеры запросов:

### Получение организаций по параметрам

***Пример запроса***
![Screenshot](/Users/hunsonabadeer/GitHub/test/images/Organizations/Screenshot 2021-05-06 at 18.23.18.png)
Запрос должен содержать объект JSON, используемый для поиска организаций:
![Screenshot](/Users/hunsonabadeer/GitHub/test/images/Organizations/Screenshot 2021-05-06 at 18.32.48.png)

Пример ответа от сервера, в результате ***успешного*** выполнения запроса:
![Screenshot](/Users/hunsonabadeer/GitHub/test/images/Organizations/Screenshot 2021-05-06 at 18.36.28.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](/Users/hunsonabadeer/GitHub/test/images/Organizations/Screenshot 2021-05-06 at 18.45.11.png)

### Получение организации по идентификатору

***Пример запроса***
![Screenshot](/Users/hunsonabadeer/GitHub/test/images/Organizations/Screenshot 2021-05-06 at 18.56.50.png)
Запрос должен содержать Id искомой организации, указывается в конце адреса запроса.

Пример ответа от сервера, в результате успешного выполнения запроса:
![Screenshot](/Users/hunsonabadeer/GitHub/test/images/Organizations/Screenshot 2021-05-06 at 19.02.23.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](/Users/hunsonabadeer/GitHub/test/images/Organizations/Screenshot 2021-05-06 at 19.16.41.png)
