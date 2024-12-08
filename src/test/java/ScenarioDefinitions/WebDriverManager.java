package ScenarioDefinitions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebDriverManager {
    private static WebDriver driver;

    // Méthode pour initialiser le driver si nécessaire
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
//            driver.manage().window().maximize();
        }
        return driver;
    }

    // Méthode pour fermer le driver
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
