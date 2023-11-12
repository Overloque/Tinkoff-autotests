package guru.qa.utils;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.Locale;

public class TestData {
    private final Faker faker = new Faker(new Locale("ru"));

    public String
            searchInput = getRandomCardType(),
            goalsInput = getRandomCreditGoal();

    public List<String>
            menuPanel = List.of("Дебетовые карты", "Кредитные карты",
            "Кредиты", "Премиум", "Вклады", "Инвестиции", "Сим-карта",
            "Страхование", "Путешествия", "Бизнес"),
            steps = List.of("Оставьте заявку на кредит, ответим сразу, в день обращения",
                    "Получите деньги на карту Тинькофф. Если ее нет, доставим бесплатно, куда удобно",
                    "Тратьте деньги с карты или снимайте наличные без комиссии");

    public String getRandomCardType() {
        return faker.business().creditCardType();
    }

    public String getRandomCreditGoal() {
        String[] goals = {"Ремонт", "Покупка недвижимости", "Покупка автомобиля",
                "Погашение кредитов", "Развитие бизнеса", "Лечение",
                "Погашение долгов (не кредиты)", "Путешествие", "Иное", "Пока не определился"};

        return faker.options().option(goals);
    }
}
