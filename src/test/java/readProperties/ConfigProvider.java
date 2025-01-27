package readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    // данный интерфейс гнужен для чтения файлов конфигурации
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile") // зачем мы делаем это условие?
        ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
        : ConfigFactory.load("application.conf");
        // данный метод возвращает значение элемента из конфига
    }

    String URL = readConfig().getString("url");
    String LOGIN = readConfig().getString("usersParams.params.login");
    String PASSWORD = readConfig().getString("usersParams.params.password");

}
