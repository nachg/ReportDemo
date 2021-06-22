import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

@Link("3c4deb63-7833-4dca-a754-42415836254f")
@Epic("UI Test")
@Feature("Демо")
class UiTest extends BaseTest {

    @Test
    public void authTest() {
        step("Открыть страницу авторизации", () ->
                clickByXpath("//a[@href='/login']")
        );
        check("Страница авторизации должна быть открыта", () -> {
            step("Поле ввода логина должно быть видимым", () ->
                    checkXpath("//input[@name='login']")
            );
            step("Поле ввода пароля должно быть видимым", () ->
                    checkXpath("//input[@name='password']")
            );
        });
    }

    @Test
    public void authTest2() {
        step("Открыть страницу авторизации", () -> {
            step("Нажать на кнопку 'login'", () ->
                    clickByXpath("//a[@href='/login']")
            );
            expect("Поле ввода логина должно быть видимым", () ->
                    checkXpath("//input[@name='login']")
            );
            expect("Поле ввода пароля должно быть видимым", () ->
                    checkXpath("//input[@name='password']")
            );
            screenshot();
        });
    }

    @Test
    public void authTest3() {
        step("Открыть страницу авторизации", () ->
                clickByXpath("//a[@href='/login']")
        );
        step("Проверка результата", () -> {
            step("Поле ввода логина должно быть видимым", () ->
                    checkXpath("//input[@name='login']")
            );
            step("Поле ввода пароля должно быть видимым", () ->
                    checkXpath("//input[@name='password']")
            );
            screenshot();
        });
    }
}