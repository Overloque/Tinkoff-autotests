package guru.qa.tests;

import guru.qa.pages.AnalyticsPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@Tag("analytics")
@Feature("Проверка страницы аналитики")
@Epic(value = "Проверка сайта Тинькофф")
@Owner("Overloque")
public class AnalyticsTests extends BaseTest {
    AnalyticsPage analyticsPage = new AnalyticsPage();

    @Test
    @DisplayName("Проверка отображения модального окна при попытке написать комментарий без брокерского счета")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Tinkoff", url = "https://www.tinkoff.ru/invest/research")
    void checkExistingCommentModal() {
        step("Открытие страницы аналитики", () ->
                analyticsPage.openPage());
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
