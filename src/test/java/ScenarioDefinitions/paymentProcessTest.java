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

public class paymentProcessTest {
    static WebDriver driver = WebDriverManager.getDriver();
//    @Given("user go the panel view")
//    public void user_go_the_panel_view() {
//        driver = WebDriverManager.getDriver();
//        driver.get("https://zoom.com.tn/panier?action=show");
//    }

    @When("user click to the command button")
    public void user_click_to_the_command_button() {
        driver.get("https://zoom.com.tn/panier?action=show");
        driver.get("https://zoom.com.tn/commande");
    }

    @And("user complete the payment forms")
     public void user_complete_the_payment_forms() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement phoneElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("shipping_address_phone")));
        phoneElement.sendKeys("55121477");
        driver.findElement(By.id("shipping_address_alias")).sendKeys("Bizerte");
        driver.findElement(By.id("shipping_address_firstname")).sendKeys("ali");
        driver.findElement(By.id("shipping_address_lastname")).sendKeys("jl");
        driver.findElement(By.id("shipping_address_company")).sendKeys("company");
        driver.findElement(By.id("shipping_address_address1")).sendKeys("address1");
        driver.findElement(By.id("shipping_address_address2")).sendKeys("zouaouine");
        driver.findElement(By.id("shipping_address_city")).sendKeys("zouaouine");
        driver.findElement(By.id("shipping_address_postal_code")).sendKeys("7024");
        driver.findElement(By.id("shipping_address_id_country")).sendKeys("Tunisie");
        WebElement Mode_de_livraison = driver.findElement(By.id("delivery_option_73"));

        if (!Mode_de_livraison.isSelected()) {
            Mode_de_livraison.click();
            System.out.println("Mode de livraison cochée avec succès.");
        } else {
            System.out.println("Mode de livraison est déjà cochée.");
        }

        WebElement Mode_de_paiement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("payment-option-1shipping_address_phone")));
        Mode_de_paiement.click();
    }

//    @Then("click on add to validate commande button")
//    public void click_on_add_to_validate_commande_button() {
//        driver.findElement(By.name("submitCompleteMyOrder")).click();
//    }


}
