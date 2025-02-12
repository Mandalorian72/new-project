package demoblaze;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginInput = $(By.id("loginusername"));
    private SelenideElement passwordInput = $(By.id("loginpassword"));
    private SelenideElement loginButton = $(By.xpath("//button[@onclick='logIn()']"));

    public MainPage login(String username, String password) {
        loginInput.setValue(username);
        passwordInput.setValue(password);
        loginButton.click();
        return new MainPage();
    }

}
