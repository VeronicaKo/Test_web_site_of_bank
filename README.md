Установить IDEA;
- Настроить проект с Maven в качестве платформы для сборки;
- Добавить Selenide, TestNG, REST-ASSURED в зависимости Maven;
- С помощью Selenide открыть и написать пару авто тестов для сайта https://www.globalsqa.com/angularJs-protractor/BankingProject/

- Кейсы можно писать любые, но обязательно надо написать кейс на логин под обычным пользователем

Доп задание (необязательное)
При помощи REST-ASSURED написать GEТ,POST,DELETE запросы к платформе
https://petstore.swagger.io

# Тест-кейс №1

| Test ID  | Name                                             |                       
| -------- | ------------------------------------------------ |  
| Log1     | Проверка авторизации в системе                   |

|Test to reproduce|	Expected Result	         |Status (passed,skipped, failed, bloked)|
| --------------- | ------------------------ | ------------------------------------- | 
|0. Открыть сайт https://www.globalsqa.com/angularJs-protractor/BankingProject/|	Открылась страница сайта с авторизацией|	pass|
|1. Нажать на кнопку "Сustomer Login"|	Открылась страница https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer|	pass|
|3. В поле "Your Name" выбрать "Albus Dumbledore"|	Должна отобразиться кнопка "Login"| 	pass|
|4. Очистить поле "Your Name" |	Поле ввода "Search products" стало невидимым|	pass|
|5. В поле "Your Name" выбрать "Neville Longbottom"|	Должна отобразиться кнопка "Login"|	pass|
|6. Нажать на кнопку "Login"|	Открылась страница https://www.globalsqa.com/angularJs-protractor/BankingProject/#/account|	pass|
|7. Проверить наличие надписи Welcome "Neville Longbottom" |	Надпись найдена|	pass|


| Test ID  | Name                                             |                       
| -------- | ------------------------------------------------ |  
| Dep1     | Проверка внесения суммы на вклад                 |

|Test to reproduce|	Expected Result	         |Status (passed,skipped, failed, bloked)|
| --------------- | ------------------------ | ------------------------------------- | 
|0. Авторизоваться в системе под именем "Neville Longbottom"|	Должна отобразиться кнопка "Login"|	pass|
|9. Ввести в поле "Account": 1015|	Нас странице должна отобразиться надпись "Account Number : 1015 , Balance : 0 , Currency : Rupee"|	pass|
|10. Нажать на кнопку "Deposit"|	Должно отобразиться поле ввода "amount"|	pass|
|11. Ввести в поле "amount": 0|	На странице не найдена надпись "Deposit Successful" |	pass|
|12. Ввести в поле "amount": 1|	На странице отобразилась надпись "Deposit Successful"|	pass|
|13. Нажать на кнопку "Deposit"| Открылась страница https://www.globalsqa.com/angularJs-protractor/BankingProject/#/listTx|	pass|
|14. Проверить наличие транзакции суммой 1| Найдена транзакция от сегодняйшней с даты суммой 1 и Transaction Type = "Credit" |	pass|

