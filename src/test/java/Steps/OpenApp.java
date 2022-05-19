package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenApp {
    WebDriver driver = new Steps.Environment().getDriver();

    public OpenApp(){}

    @Given("I open the app")
    public void Verify_if_the_list_is_displayed() throws InterruptedException {
        driver.get("https://betterqa.ro/top-movies");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @When("I complete the password and the app is loaded")
    public void I_complete_the_password() throws InterruptedException {
        driver.findElement(By.id("pwbox-4212")).sendKeys("do_not_share!1");
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div/form/p[2]/input")).click();
        Thread.sleep(2000);
    }

    @Then("A list of movies is displayed")
    public void The_list_is_displayed() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[2]/h2"));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/h2"));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[3]/div[2]/h2"));
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/h2"));
        System.out.println("The list has been displayed successfully");
    }
}