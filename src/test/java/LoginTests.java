import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ModalOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginTests {
    private final static String LOGIN = "alexey777";
    private final static String PASSWORD = "1234";
    private final static String LINK = "https://www.demoblaze.com";



    @Test
    void successfullLoginTest() {

        //обчный тест состоит из 3 частей
        // ARRANGE - подготовка
        // ACT - действие
        // ASSERT - проверка.
        //Каждый тест обязательно должен заканчиваться ASSERTом

        //SelenideElement nameOfElement = "dffv" - призваивает элементу какое-либо значение
        Configuration.timeout = 20000; // настройка таймаута ожидания браузера перед выбросом исключения в случае ошибки
        open(LINK); //открытие браузера


        Configuration.holdBrowserOpen = true; // флаг незакрывания браузера, для того что он не закрывался
//        Configuration.browser = "Название браузера"; позволяет открыть конкретный браузер
//        Configuration.browserSize = "800x400"; - задает размер браузеру


        $(By.xpath("//a[@class='nav-link'][@data-target='#logInModal']")).shouldHave(text("Log in")); //проверяет наличие элемента с текстом "Log in" на странице
        $(By.xpath("//a[@class='nav-link'][@data-target='#logInModal']")).click(); // кликает по элементу Log in, пердварительно найдя его на странице;
        $(By.xpath("//input[@id='loginusername']")).setValue(LOGIN);  //вводим логин пароль
        //если добавить .pressEnter в конце строки, то нажмется Enter в конце исполнения строки
        $(By.xpath("//input[@id='loginpassword']")).setValue(PASSWORD);//как сюда ввести цифры
        $(By.xpath("//button[@onclick='logIn()']")).click(); //нажимаем кнопку авторизации
        $(By.xpath("//a[@id='nameofuser']")).shouldHave(text("Welcome alexey777")); //проверяет наличие элемента с текстом имени польщователя

        // в ситуации когда тест нельзя сделать в течение 4 секунд то он падает
        $(By.xpath("(//a[@href='prod.html?idp_=8'])[2]")).click(); // поиск элемента по номеру расположения
        $(By.xpath("//a[@onclick='addToCart(8)']")).click();
        Selenide.switchTo().alert().accept(); // закрытие аллерата(всплывающего окна)
        $(By.xpath("//a[@onclick='addToCart(8)']")).click();
        Selenide.switchTo().alert().accept(); // закрытие аллерата(всплывающего окна)
        $(By.xpath("//a[@href='cart.html']")).click();
        $(By.xpath("//a[contains(@onclick, 'delete')]")).click();
    }
}
