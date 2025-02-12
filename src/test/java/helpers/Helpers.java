package helpers;

import com.codeborne.selenide.Selenide;

public class Helpers {

    public static void closeAlert() {
        Selenide.switchTo().alert().accept();
    }


}
