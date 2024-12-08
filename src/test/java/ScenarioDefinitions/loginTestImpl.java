package ScenarioDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginTestImpl {
    static WebDriver driver;
    @Given("user on login page")
    public void user_on_login_page() {
        driver = WebDriverManager.getDriver();
        driver.get("https://zoom.com.tn/connexion?back=https://zoom.com.tn/");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        driver.findElement(By.id("field-email")).sendKeys("mail@gmail.com.com");
        driver.findElement(By.id("field-password")).sendKeys("Ma14d");
    }

    @And("Clicks on login Button")
    public void clicks_on_login_button() {
        driver.findElement(By.id("submit-login")).click();
    }

    @Then("user is navigated to home page")
    public void user_is_navigated_to_home_page() {
        // Vérifiez si l'utilisateur est bien redirigé
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("zoom")) {
            System.out.println("Navigation réussie !");
        } else {
            System.out.println("Échec de la navigation : " + currentUrl);
        }
    }

//    @When("user enters the product name in the search bar")
//    public void user_enters_the_product_name_in_the_search_bar() {
//        driver.findElement(By.name("s")).sendKeys("V3500I3 LAP-D465");
//    }
//
//    @And("clicks on the search button")
//    public void clicks_on_the_search_button() {
//        driver.findElement(By.className("btn-primary")).click();
//    }
//
//    @Then("the product results are displayed on the results page")
//    public void the_product_results_are_displayed_on_the_results_page() {
//    }

}

