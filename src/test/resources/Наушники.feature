#language: ru

Функционал: Яндекс Маркет
Сценарий: Поиск и выбор наушников

Когда Выбран пункт меню "Маркет"
Когда Выбран пункт маркет-меню "Электроника"

Когда Заголовок страницы Электроника - "Электроника"
Тогда Выбран пункт электроника-меню "Наушники и Bluetooth-гарнитуры"

Когда Заголовок страницы - "Наушники и Bluetooth-гарнитуры"
Тогда Включается CheckBox для - "Производитель Beats"
Тогда Заполняются поля:
|glpricefrom|5000|
Когда Выбирается колличество элементов поиска на странице :"Показывать по 12"
Тогда Проверяется, что колличество элементов поиска на странице :"Показывать по 12"
Когда Получено название первого элемента поиска на странице
Тогда Поиск
Тогда Клик
Тогда Проверка