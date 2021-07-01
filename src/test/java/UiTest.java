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
    public void authTest1() {
        step("Открыть страницу авторизации", () -> {
            clickByXpath("//a[@href='/login']");

            check("Страница авторизации должна быть открыта", () -> {
                step("Поле ввода логина должно быть видимым", () ->
                        checkXpath("//input[@name='login']")
                );
                step("Поле ввода пароля должно быть видимым", () ->
                        checkXpath("//input[@name='password']")
                );
            });
        });
    }

    @Test
    public void authTest2() {
        step("1. Открыть страницу авторизации", () -> {
            step("1.1. Нажать на кнопку 'login'", () -> {
                clickByXpath("//a[@href='/login']");
                expect("Просто проверить что-то во внутреннем шаге", () ->
                        checkXpath("//input[@name='login']")
                );
                step("1.1.1 И еще один внутренний шаг", () -> {
                    expect("И еще одна внутренняя проверка", () ->
                            System.out.println()
                    );
                });
            });
            step("1.2. Что-нибудь сделать", () -> {

            });
            expect("Поле ввода логина должно быть видимым", () ->
                checkXpath("//input[@name='login']")
            );
            expect("Поле ввода пароля должно быть видимым", () ->
                checkXpath("//input[@name='password']")
            );
            screenshot();
        });
        step("2. Шаг второй", () -> {
            step("2.1 Нажать на кнопку 'login'", () -> {
                expect("Просто проверить что-то во внутреннем шаге", () ->
                        checkXpath("//input[@name='login']")
                );
                step("2.2. И еще один внутренний шаг", () -> {
                    expect("И еще одна внутренняя проверка", () ->
                            System.out.println()
                    );
                });
            });
        });
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