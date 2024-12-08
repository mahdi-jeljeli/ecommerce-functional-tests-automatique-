package ScenarioDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class addToCartTest {
    static WebDriver driver = WebDriverManager.getDriver();
//    @Given("user is on the product details page")
//    public void user_is_on_the_product_details_page() {
//        driver = WebDriverManager.getDriver();
////        driver.get("https://zoom.com.tn/pc-portables/12821-pc-portable-vostro-3500-i3-11e-gen-8go-256go-ssd-v3500i3.html");
//    }

    @When("user enter the quantity in the input field")
    public void user_enter_the_quantity_in_the_input_field() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quantityInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("quantity_wanted")));
        quantityInput.sendKeys("1");

    }

    @And("click on add to pannier button")
    public void clicks_on_the_search_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("add-to-cart")));
        addToCartButton.click();;
    }

    @Then("check the result")
    public void check_the_result() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expectedMessage = "Il y a 11 article dans votre panier.";

        // Attendre jusqu'à ce que le texte soit mis à jour
        String message = wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.className("cart-products-count"), "1")).toString();

        if (message.equals(expectedMessage)) {
            System.out.println("Quantity exact and validation successful.");
        } else {
            System.out.println("Add to cart not valid: " + message);
        }
    }

}
