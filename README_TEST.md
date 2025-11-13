Початок виконання тестування:
1. На комп'ютері має бути встановлено: IntelliJ IDEA,JAVA, MAVEN, SELENIUM, TESTNG.
2. Зклонуй відповідний репозиторій 
3. Відкрий його в IntelliJ IDEA.
4. Знайди файл `SeleniumTestngTest.java`.
5. Переконайся, що всі тести створені.
   Список тестів:
    - abTestingPageHasSpecificTextTest — перевірка заголовку A/B Testing сторінки
    - abTestingPageHasSpecificTextTest — перевірка заголовку A/B Testing сторінки
    - addRemoveElementsTest — додавання та видалення елементів
    - addCheckboxTest — робота з чекбоксами
    - dropdownSelectionTest — робота з випадаючим списком
    - loginLogoutTest — перевірка логіну та логауту
    - dragAndDropElementsTest — Drag & Drop елементів
    - sliderElementTest — робота з горизонтальним слайдером
6. Виконай Run`SeleniumTestngTest`.

7. Виконай Maven build за допомогою терміналу, відкрий термінал у папці з проектом та введи:
   ```bash
   mvn clean test
   ```
8. Результат успішного Maven build виглядає так:
   [INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 15.10 s -- in TestSuite
   [INFO]
   [INFO] Results:
   [INFO]
   [INFO] Tests run: 7, Failures: 0, Errors: 0, Skipped: 0
   [INFO]
   [INFO] ------------------------------------------------------------------------
   [INFO] BUILD SUCCESS
   [INFO] ------------------------------------------------------------------------
   [INFO] Total time:  22.429 s
   [INFO] Finished at: 2025-11-13T10:56:53+02:00
   [INFO] ------------------------------------------------------------------------
   PS X:\_projects\12-webui-testing-framework-Iryna9105> 