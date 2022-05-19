package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BugFound {
    WebDriver driver = new Steps.Environment().getDriver();

    public BugFound(){}

    @Given("I open application BetterQA")
    public void Verify_if_the_list_is_displayed() throws InterruptedException {
        driver.get("https://betterqa.ro/top-movies");
        driver.manage().window().maximize();
        driver.findElement(By.id("pwbox-4212")).sendKeys("do_not_share!1");
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div/form/p[2]/input")).click();
    }

    @When("I search for nothing and press enter")
    public void I_complete_the_password() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/input")).sendKeys("");
        WebElement textbox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/input"));
        textbox.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
    }

    @Then("The page should refresh or stay the same")
    public void The_list_is_displayed() throws InterruptedException {
        if(driver.getPageSource().contains("The Shawshank Redemption"))
        {
            System.out.println("The page just refreshed.");
        }

        else
        {
            System.out.println("A bug has been found, the page became empty after searching for nothing.");
        }
    }
}
