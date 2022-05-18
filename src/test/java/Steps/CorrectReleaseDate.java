package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CorrectReleaseDate {
    WebDriver driver = new Steps.Environment().getDriver();

    public CorrectReleaseDate(){}

    @Given("I open the application")
    public void Verify_if_the_list_is_displayed() throws InterruptedException {
        driver.get("https://betterqa.ro/top-movies");
        driver.manage().window().maximize();
        driver.findElement(By.id("pwbox-4212")).sendKeys("do_not_share!1");
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div/form/p[2]/input")).click();
        Thread.sleep(2000);
    }

    @When("I open the movie The Shawshank Redemption")
    public void I_open_the_movie() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/button/span[1]")).click();
        Thread.sleep(2000);
    }

    @Then("The release date is correctly displayed")
    public void The_list_is_displayed() throws InterruptedException {
        Thread.sleep(2000);

        String dateOnApp = driver.findElement(By.xpath("//div[@role=\"document\"]/div[2]/div[2]/div/input")).getAttribute("value");

        String expectedDate = "1994-09-22";
        if ( dateOnApp.equals(expectedDate) )
        {
            System.out.println("The date is correctly displayed");
        }
        else
        {
            System.out.println("The date is not correctly displayed");
        }
    }
}
