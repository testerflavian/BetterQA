 package Steps;

 import io.cucumber.java.en.Given;
 import io.cucumber.java.en.Then;
 import io.cucumber.java.en.When;
 import org.openqa.selenium.*;

 public class ExpectedValues {
     WebDriver driver = new Steps.Environment().getDriver();

     public ExpectedValues() {
     }

     @Given("I open app BetterQA")
     public void Verify_if_the_list_is_displayed() throws InterruptedException {
         driver.get("https://betterqa.ro/top-movies");
         driver.manage().window().maximize();
         driver.findElement(By.id("pwbox-4212")).sendKeys("do_not_share!1");
         driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div/div/div/form/p[2]/input")).click();
         Thread.sleep(2000);
     }

     @When("I search for {string}")
     public void I_open_the_movie(String movie_name) throws InterruptedException {
         driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/input")).sendKeys(movie_name);
         WebElement textbox = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/div/form/div/input"));
         textbox.sendKeys(Keys.ENTER);
         Thread.sleep(2000);
         ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
         driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/div[3]/button/span[1]")).click();
         Thread.sleep(2000);
     }

     @Then("Check that released date is {string}, popularity is {string}, vote average is {string} and vote count is {string}")
     public void The_list_is_displayed(String release_date, String popularity, String vote_average, String vote_count) throws InterruptedException {
         Thread.sleep(2000);
         String dateField = driver.findElement(By.xpath("//div[@role=\"document\"]/div[2]/div[2]/div/input")).getAttribute("value");
         String popularityField = driver.findElement(By.xpath("//div[@id=\"form-dialog-title\"]//following-sibling::div/div[3]/div/input")).getAttribute("value");
         String voteAverageField = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[4]/div/input")).getAttribute("value");
         String voteCountField = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[2]/div[5]/div/input")).getAttribute("value");

         if (dateField.equals(release_date))
         {
             System.out.println("The date is correctly displayed");
         }
         else
         {
             System.out.println("The date is not correctly displayed");
         }

         if (popularityField.equals(popularity))
         {
             System.out.println("The popularity is correctly displayed");
         }
         else
         {
             System.out.println("The popularity is not correctly displayed");
         }

         if (voteAverageField.equals(vote_average))
         {
             System.out.println("The vote average is correctly displayed");
         }
         else
         {
             System.out.println("The vote average is not correctly displayed");
         }

         if (voteCountField.equals(vote_count))
         {
             System.out.println("The vote count is correctly displayed");
         }
         else
         {
             System.out.println("The vote count is not correctly displayed");
         }
     }
 }