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

### Изменение данных организации 

***Пример запроса***
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2019.48.11.png)

Запрос должен содержать объект JSON, используемый для изменения организации:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2019.48.22.png)

Пример ответа от сервера, в результате ***успешного*** выполнения запроса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2019.48.28.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2018.45.11.png)

### Сохранение новой организации 

***Пример запроса***
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2019.48.43.png)

Запрос должен содержать объект JSON, используемый для сохранения организации:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2019.48.46.png)

Пример ответа от сервера, в результате ***успешного*** выполнения запроса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2019.48.50.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Organizations/Screenshot%202021-05-06%20at%2018.45.11.png)

### Получение списка офисов по параметрам

***Пример запроса***
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/Screenshot%202021-05-06%20at%2019.50.09.png)

Запрос должен содержать объект JSON, используемый для поиска офисов:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/Screenshot%202021-05-06%20at%2019.50.12.png)

Пример ответа от сервера, в результате ***успешного*** выполнения запроса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/Screenshot%202021-05-06%20at%2019.50.17.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/OfficeError.png)

### Получение офиса по Id

***Пример запроса***
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/Screenshot%202021-05-06%20at%2019.49.26.png)
Запрос должен содержать Id офиса, указывается в конце адреса запроса.

Пример ответа от сервера, в результате ***успешного*** выполнения запроса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/Screenshot%202021-05-06%20at%2019.49.33.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/Screenshot%202021-05-06%20at%2019.49.52.png)

### Изменение данных офиса

***Пример запроса***
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/Screenshot%202021-05-06%20at%2019.50.26.png)

Запрос должен содержать объект JSON, используемый для изменения данных офиса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/Screenshot%202021-05-06%20at%2019.50.29.png)

Пример ответа от сервера, в результате ***успешного*** выполнения запроса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/Screenshot%202021-05-06%20at%2019.50.34.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/OfficeError.png)

### Сохранение нового офиса

***Пример запроса***
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/Screenshot%202021-05-06%20at%2019.50.49.png)

Запрос должен содержать объект JSON, используемый для сохранения данных офиса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/Screenshot%202021-05-06%20at%2019.50.29.png)

Пример ответа от сервера, в результате ***успешного*** выполнения запроса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/Screenshot%202021-05-06%20at%2019.50.54.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Office/OfficeError.png)

### Получение списка сотрудников по параметрам

***Пример запроса***
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/Screenshot%202021-05-06%20at%2019.52.47.png)

Запрос должен содержать объект JSON, используемый для поиска сотрудников:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/Screenshot%202021-05-06%20at%2019.52.56.png)

Пример ответа от сервера, в результате ***успешного*** выполнения запроса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/Screenshot%202021-05-06%20at%2019.53.01.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/UserError.png)

### Получение сотрудника по Id

***Пример запроса***
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/Screenshot%202021-05-06%20at%2019.53.47.png)
Запрос должен содержать Id сотрудника, указывается в конце адреса запроса.

Пример ответа от сервера, в результате ***успешного*** выполнения запроса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/Screenshot%202021-05-06%20at%2019.53.55.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/Screenshot%202021-05-06%20at%2019.54.03.png)

### Изменение данных сотрудника

***Пример запроса***
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/Screenshot%202021-05-06%20at%2019.54.10.png)

Запрос должен содержать объект JSON, используемый для изменения данных сотрудника:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/Screenshot%202021-05-06%20at%2019.54.15.png)

Пример ответа от сервера, в результате ***успешного*** выполнения запроса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/Screenshot%202021-05-06%20at%2019.54.18.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/UserError.png)

### Сохранение нового сотрудника

***Пример запроса***
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/Screenshot%202021-05-06%20at%2019.54.24.png)

Запрос должен содержать объект JSON, используемый для сохранения данных сотрудника:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/Screenshot%202021-05-06%20at%2019.54.27.png)

Пример ответа от сервера, в результате ***успешного*** выполнения запроса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/Screenshot%202021-05-06%20at%2019.54.30.png)

Пример ответа от сервера, при возникновении ***ошибки***:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/User/UserError.png)

### Получение списка кодов и наименований стран

***Пример запроса***
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Country/Screenshot%202021-05-06%20at%2019.51.54.png)

Пример ответа от сервера, в результате ***успешного*** выполнения запроса:
![Screenshot](https://github.com/HunsonAbadeer1989/TestIntegrator/blob/master/images/Country/Screenshot%202021-05-06%20at%2019.52.04.png)

