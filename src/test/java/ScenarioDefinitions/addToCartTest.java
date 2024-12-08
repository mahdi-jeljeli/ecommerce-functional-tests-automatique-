package ScenarioDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class addToCartTest {
    static WebDriver driver = WebDriverManager.getDriver();
    @When("user enter the quantity in the input field")
    public void user_enter_the_quantity_in_the_input_field() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement quantityInput = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-touchspin")));
        try {
            WebElement quantityButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-touchspin.js-touchspin.bootstrap-touchspin-up")));
            for (int i = 0; i < 3; i++) {
                quantityButton.click();
            }
        } catch (TimeoutException e) {
            System.out.println("Le bouton d'augmentation de quantité n'a pas pu être trouvé ou est bloqué.");
        }


    }

    @And("click on add to pannier button")
    public void clicks_on_the_search_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("add-to-cart")));
        addToCartButton.click();;
    }

    @Then("check the result")
    public void check_the_result() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            // Attendre jusqu'à ce que le texte attendu soit présent
            boolean isTextPresent = wait.until(ExpectedConditions.textToBePresentInElementLocated(
                    By.className("cart-products-count"), "Il y a 4 articles dans votre panier."));

            // Valider le texte
            if (isTextPresent) {
                System.out.println("Quantity exact and validation successful.");
            } else {
                System.out.println("Add to cart not valid.");
            }
        } catch (TimeoutException e) {
            // Gestion du cas où le texte n'apparaît pas dans le délai imparti
            String actualMessage = driver.findElement(By.className("cart-products-count")).getText();
            System.out.println("Timeout waiting for text. Current text is: " + actualMessage);
        }
    }

    }

