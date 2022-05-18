package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;


public class SearchMovie {
    WebDriver driver = new Steps.Environment().getDriver();

    public SearchMovie(){}

    @Given("I open BetterQA")
    public void Verify_if_the_list_is_displayed() throws InterruptedException {
        driver.get("https://betterqa.ro/top-movies");
        driver.manage().window().maximize();
        driver.findElement(By.id("pwbox-4212")).sendKeys("do_not_share!1");
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div/form/p[2]/input")).click();
    }

    @When("I search for Star Trek")
    public void I_open_the_movie() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/input")).sendKeys("Star Trek");
        WebElement textbox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/input"));
        textbox.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @Then("Star Trek: First Contact is displayed and The Shawshank Redemption is no longer visible")
    public void The_list_is_displayed() throws InterruptedException {
        if(driver.getPageSource().contains("Star Trek: First Contact"))
        {
            System.out.println("Star Trek: First Contact is displayed");
        }

        else
        {
            System.out.println("Star Trek: First Contact is not displayed");
        }

        if(driver.getPageSource().contains("The Shawshank Redemption"))
        {
            System.out.println("The Shawshank Redemption is visible");
        }

        else
        {
            System.out.println("The Shawshank Redemption is no longer visible");
        }
    }
}


