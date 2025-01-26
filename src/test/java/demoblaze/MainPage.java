package demoblaze;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import readProperties.ConfigProvider;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement mainLogButton = $x("//a[@id='login2']");
    private final SelenideElement inputLogin = $x("//input[@id='loginusername']");
    private final SelenideElement inputPassword = $x("//input[@id='loginpassword']");
    private final SelenideElement logButton = $x("//button[@onclick='logIn()']");
    private final SelenideElement computer = $x("(//a[@href=\"prod.html?idp_=8\"])[2]");


    //создать список элементов, потом
    // создать конструктор, чтобы обращаться к каждому элементу этого
    //класса из конструктора

    public MainPage() {
        Selenide.open(ConfigProvider.URL);
    }

    public MainPage openModalWindow() {
        mainLogButton.click();
        return this;
    }

    public MainPage authorization(String login, String password) {
        openModalWindow();
        inputLogin.setValue(login);
        inputPassword.setValue(password);
        logButton.click();
        // если страница сайта длинная, а элемент который нужно кликнуть находится внизу, нужно ли опускаться вниз перед кликом на элемент?
        return this; //зачем нужно здесь возвращать объект?
    }

    public ProductComputerCard goingToComputerPage(){
        computer.scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}").click();
        return new ProductComputerCard();
        // если страница сайта длинная, а элемент который нужно кликнуть находится внизу,
        // нужно ли опускаться вниз перед кликом на элемент?
        //почему скрол не работает в данной ситуации,
        // не происходит визуального скрола до элемента?
    }


}
