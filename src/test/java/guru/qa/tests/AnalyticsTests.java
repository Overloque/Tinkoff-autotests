package guru.qa.tests;

import guru.qa.pages.AnalyticsPage;
import guru.qa.pages.MainPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

@Tag("analytics")
@Feature("Проверка страницы аналитики")
@Epic(value = "Проверка сайта Тинькофф")
@Owner("Overloque")
public class AnalyticsTests extends TestBase {
    AnalyticsPage analyticsPage = new AnalyticsPage();
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка отображения модального окна при попытке написать комментарий без брокерского счета")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Tinkoff", url = "https://www.tinkoff.ru/invest/research")
    void checkExistingCommentModal() {
        step("Открытие главной страницы", () ->
                mainPage.openPage());
        step("Выбор у popover'а 'Частным лицам' пункта 'Аналитика' ", () ->
                analyticsPage.hoverAndClick());
        step("Открытие новости из списка", () ->
                analyticsPage.clickRecentNews());
        step("Активирование блока с комментарием", () -> {
            analyticsPage.checkPostExist();
            analyticsPage.clickComment();
        });
        step("Проверка появления модального окна с предупреждением", () -> {
            analyticsPage.checkPopUpExist();
            analyticsPage.checkPopUpText();
        });
    }
}
