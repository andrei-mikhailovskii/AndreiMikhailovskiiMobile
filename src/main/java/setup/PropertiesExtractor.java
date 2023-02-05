package setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesExtractor {

    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";
    protected static String email;
    protected static String userName;
    protected static String password;

    public static Properties getProperties() {

        Properties properties = new Properties();

        try (InputStream input = new FileInputStream(CONFIG_FILE_PATH)) {
            properties.load(input);
            email = properties.getProperty("email");
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

}
