package core;

/**
 *абстрактный класс для инициализации селенида
 */

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

abstract public class BaseTest {

    /**
     * Выполнение метода перед каждым запуском тестов
     */
    @BeforeEach
    public void init(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        //Configuration.driverManagerEnable = true; - не нашел библиотеку для этой команды
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false; // отвечает за то, будем ли мы видеть сам браузер при выполнении тестов.
        //по-этому конфигурация хэдлес создает некий виртуальный экран,
        // и внутри этого виртуального пространства выполняется вся тэстовая логика.
        // при этом, если мы хотим видеть своими глазами что происходит,
        // мы ставим true, если не хотим, false.
        Configuration.timeout = 30000;
        Configuration.holdBrowserOpen = Boolean.parseBoolean(System.getProperty("holdBrowserOpen", "false")); // открытие бразера при запуске тестов локально. На проде отключено
    }

    /**
     * Выполнение метода после каждого запуска тестов
     */
    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
