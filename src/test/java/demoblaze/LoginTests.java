package demoblaze;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.BaseTest;
import helpers.TestValues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import readProperties.ConfigProvider;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class LoginTests extends BaseTest {

    @Test
    void successfullLoginTest() {
        String secondComputer = TestValues.TEST_COMPUTER;

        CartPage product = new MainPage().openModalWindow().login(ConfigProvider.LOGIN, ConfigProvider.PASSWORD)
                .goingToComputerPage()
                .addProduct().goingToCart();

        Assertions.assertTrue(product.getSecondComputer().contains(TestValues.TEST_COMPUTER));
    }


//обычный тест состоит из 3 частей
        // ARRANGE - подготовка
        // ACT - действие
        // ASSERT - проверка.
        //Каждый тест обязательно должен заканчиваться ASSERTом

//        $(By.xpath("//a[@class='nav-link'][@data-target='#logInModal']")).shouldHave(text("Log in")); //проверяет наличие элемента с текстом "Log in" на странице
//        $(By.xpath("//a[@class='nav-link'][@data-target='#logInModal']")).click(); // кликает по элементу Log in, пердварительно найдя его на странице;
//        $(By.xpath("//input[@id='loginusername']")).setValue(LOGIN);  //вводим логин пароль
//        //если добавить .pressEnter в конце строки, то нажмется Enter в конце исполнения строки
//        $(By.xpath("//input[@id='loginpassword']")).setValue(PASSWORD);//как сюда ввести цифры
//        $(By.xpath("//button[@onclick='logIn()']")).click(); //нажимаем кнопку авторизации
//        $(By.xpath("//a[@id='nameofuser']")).shouldHave(text("Welcome alexey777")); //проверяет наличие элемента с текстом имени польщователя
//
//
//        $(By.xpath("(//a[@href='prod.html?idp_=8'])[2]")).click(); // поиск элемента по номеру расположения
//        $(By.xpath("//a[@onclick='addToCart(8)']")).click();
//        Selenide.switchTo().alert().accept(); // закрытие аллерата(всплывающего окна)
//        $(By.xpath("//a[@onclick='addToCart(8)']")).click();
//        Selenide.switchTo().alert().accept(); // закрытие аллерата(всплывающего окна)
//        $(By.xpath("//a[@href='cart.html']")).click();
//        $(By.xpath("//a[contains(@onclick, 'delete')]")).click();
}
