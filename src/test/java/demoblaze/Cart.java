package demoblaze;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Cart {
    public Cart() {
    }

    private SelenideElement SECOND_COMPUTER = $x("(//td[text()='Sony vaio i5'])[2]");


    public String getSecondComputer() {
        return SECOND_COMPUTER.getText();
    }
}
