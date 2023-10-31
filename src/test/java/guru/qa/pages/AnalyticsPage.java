package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class AnalyticsPage {
    private final SelenideElement
            menuPopover = $(byText("Частным лицам")),
            analyticsOption = $("[data-test=text-item-1-4-wrapper]"),
            recentNewsBlock = $$("[data-qa-file=ResearchRecentNews]").get(0),
            commentBlock = $("[data-qa-file=ProfilePostFormUnauthorized]").$(byText("Ваш комментарий...")),
            post = $("[data-qa-tag=PulsePost]"),
            popUpWindow = $("[data-qa-file=Paper]");

    public AnalyticsPage hoverAndClick() {
        menuPopover.hover();
        analyticsOption.click();
        webdriver().shouldHave(url("https://www.tinkoff.ru/invest/research/"));

        return this;
    }

    public AnalyticsPage clickRecentNews() {
        recentNewsBlock.click();

        return this;
    }

    public AnalyticsPage clickComment() {
        commentBlock.click();

        return this;
    }

    public AnalyticsPage checkPostExist() {
        post.should(exist).shouldBe(visible);

        return this;
    }

    public AnalyticsPage checkPopUpExist() {
        popUpWindow.should(exist);

        return this;
    }

    public AnalyticsPage checkPopUpText() {
        popUpWindow.shouldHave(text("Нужен брокерский счет " +
                "Чтобы подписываться на инвесторов, комментировать и ставить лайки"));

        return this;
    }
}
