package demoblaze;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import helpers.Helpers;
import readProperties.ConfigProvider;
import static com.codeborne.selenide.Selenide.$x;

public class ProductComputerCard {

    private final SelenideElement btnSuccess = $x("//a[@class='btn btn-success btn-lg']");
    private final SelenideElement cart = $x("//a[@id='cartur']");

    public ProductComputerCard() {
    } // мы создаем конструктор только лишь для того,
    // чтобы потом в основном классе создавать объект этого класса
    // и запускать методы через него?

    public ProductComputerCard addProduct() {
        btnSuccess.click();
        Helpers.closeAlert();
        return this; // если мы уберем this, т.е. возврат объекта этого же класса
        // то у нас исчезнет возможность вызывать цепочки методов.
        // как например в классе LoginTests стр. 21 mainPage.goingToComputerPage().addProduct().closeAlert();
    }

    public Cart goingToCart() {
        cart.click();
        return new Cart();
    }
}
