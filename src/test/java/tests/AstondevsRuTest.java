package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("main")
public class AstondevsRuTest extends TestBase {

    @DisplayName("Проверка разделов меню на главной странице")
    @org.junit.jupiter.api.Test
    void menuOnMainPageTest() {
        step("Открываем главную страницу сайта", () -> {
            open("/");
        });
        step("Проверяем наличие раздела 'О нас' в меню сайта", () -> {
            $("[href=\"\\/about-us\"]").shouldBe(visible).shouldHave(text("О нас"));
        });
        step("Проверяем наличие раздела 'Услуги' с выпадающим списком в меню сайта", () -> {
            $("#menu-button-\\:R2kt59bqH1\\:").shouldBe(visible).shouldHave(text("Услуги"));
            $("#menu-button-\\:R2kt59bqH1\\:").click();
            $("[href=\"\\/1C\"]").shouldBe(visible).shouldHave(text("1С-разработка"));
            $("[href=\"\\/services/managed-delivery\"]").shouldBe(visible).shouldHave(text("Проектная разработка"));
            $("[href=\"\\/services/software-team-staff-augmentation\"]").shouldBe(visible).shouldHave(text("Расширение команды"));
            $("[href=\"\\/services/financial-services\"]").shouldBe(visible).shouldHave(text("ФинТех"));
        });
        step("Проверяем наличие раздела 'Проекты' в меню сайта", () -> {
            $("[href=\"\\/our-projects\"]").shouldBe(visible).shouldHave(text("Проекты"));
        });
        step("Проверяем наличие раздела 'Работа в ASTON' с выпадающим списком в меню сайта", () -> {
            $("#menu-button-\\:R34t59bqH1\\:").shouldBe(visible).shouldHave(text("Работа в ASTON"));
            $("#menu-button-\\:R34t59bqH1\\:").click();
            $("[href=\"\\https://career.astondevs.ru/\"]").shouldBe(visible).shouldHave(text("Карьера"));
            $("[href=\"\\https://career.astondevs.ru/vacancy\"]").shouldBe(visible).shouldHave(text("Вакансии"));
            $("[href=\"\\https://career.astondevs.ru/trainee\"]").shouldBe(visible).shouldHave(text("Стажировка"));
        });
    }
}
