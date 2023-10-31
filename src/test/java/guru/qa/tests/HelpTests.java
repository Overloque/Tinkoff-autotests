package guru.qa.tests;

import guru.qa.pages.HelpPage;
import guru.qa.pages.MainPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.qameta.allure.Allure.step;

@Tag("help")
@Feature("Проверка страницы помощи")
@Epic(value = "Проверка сайта Тинькофф")
@Owner("Overloque")
public class HelpTests extends TestBase {
    HelpPage helpPage = new HelpPage();
    MainPage mainPage = new MainPage();

    @CsvFileSource(
            resources = "/searchHelp.csv"
    )
    @ParameterizedTest(name = "При вводе запроса {0}, после перехода на страницу должен отображаться заголовок {1}")
    @DisplayName("Проверка заголовков страниц через параметры")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Tinkoff", url = "https://www.tinkoff.ru/help/what-to-do")
    void checkPageTitleAfterSearch(String searchInput, String value) {
        step("Открытие главной страницы", () ->
                mainPage.openPage());
        step("Выбор у popover'а 'Еще' пункта 'Спрашивают сейчас' ", () ->
                helpPage.hoverAndClick());
        step("Активация поля ввода по клику", () ->
                helpPage.clickSearchField());
        step("Ввод значения в поле ввода и выбор первого запроса из подсказок", () -> {
            helpPage.typeRequest(searchInput);
            helpPage.chooseFirstSearchTip();
        });
        step("Проверка заголовка страницы, на которую перешли", () -> {
            helpPage.checkTitlePage(value);
        });
    }
}
