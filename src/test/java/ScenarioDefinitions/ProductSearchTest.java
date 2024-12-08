package ScenarioDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class ProductSearchTest extends BaseTest {
    private WebDriver driver = WebDriverManager.getDriver();
    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        driver = WebDriverManager.getDriver();
//        driver.get("https://zoom.com.tn/");
    }

    @When("user enters the product name in the search bar")
    public void user_enters_the_product_name_in_the_search_bar() {
        driver.findElement(By.name("s")).sendKeys("V3500I3 LAP-D465");
    }

    @And("clicks on the search button")
    public void clicks_on_the_search_button() {
        driver.findElement(By.className("btn-primary")).click();
    }

    @Then("the product results are displayed on the results page")
    public void the_product_results_are_displayed_on_the_results_page() {
    }


    @And("user click on details link")
    public void user_click_on_details_link() {
        WebElement element = driver.findElement(By.className("product-cover-link"));
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        } else {
            System.out.println("Element is not clickable.");
        }

    }



}
