package helpers;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import demoblaze.Cart;

import static com.codeborne.selenide.Selenide.$x;

public class Helpers {

    public static void closeAlert() {
        Selenide.switchTo().alert().accept();
    }


}
