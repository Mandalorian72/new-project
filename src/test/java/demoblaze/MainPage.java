package demoblaze;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import readProperties.ConfigProvider;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement mainLogButton = $x("//a[@id='login2']");
    private final SelenideElement computer = $x("(//a[@href=\"prod.html?idp_=8\"])[2]");

    //создать список элементов, потом
    // создать конструктор, чтобы обращаться к каждому элементу этого
    //класса из конструктора

    public MainPage() {
        Selenide.open(ConfigProvider.URL);
    }

    public LoginPage openModalWindow() {
        mainLogButton.click();
        return new LoginPage();
    }

    public ProductComputerCard goingToComputerPage(){
        computer.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}").click();
        return new ProductComputerCard();
    }


}
