package stepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ElearningPage {
	public WebDriver driver;
	@Test
	@Given("User navigates to Elearning Portal")
	public void user_navigates_to_Elearning_Portal() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "D:\\Test Automation Software - Swati\\chromedriver_win32\\chromedriver.exe");

		 driver= new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/index.php");
		driver.manage().window().maximize();
	}
    @Test
	@When("User clicks on Signup")
	public void user_clicks_on_Signup() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.linkText("Sign up!")).click();
	}
    @Test
	@When("User fills up the registration form with {string},{string},{string},{string},{string},{string}")
	public void user_fills_up_the_registration_form_with(String FirstName, String LastName, String Email, String Username, String Password, String CnfmPassword) {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.xpath("//*[@name='firstname']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys(LastName);
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys(Email);
		driver.findElement(By.id("username")).sendKeys(Username);
		driver.findElement(By.cssSelector("input#pass1")).sendKeys(Password);
		driver.findElement(By.cssSelector("input#pass2")).sendKeys(CnfmPassword);
	}
    @Test
	@When("User clicks on Register")
	public void user_clicks_on_Register() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//*[@id=\"registration\"]/fieldset/div[16]/div[1]/button")).submit();
	}
    @Test
	@Then("User validates the registration message")
	public void user_validates_the_registration_message() {
	    // Write code here that turns the phrase above into concrete actions
	    String confMessage=driver.findElement(By.xpath("//*[text()='Your personal settings have been registered.']")).getText();
	    System.out.println("Message is "+confMessage);
	    
	    List<WebElement> confirmationtexts = driver.findElements(By.tagName("p"));
        System.out.println(confirmationtexts.size());
        for (WebElement webElement : confirmationtexts) {
            String texts = webElement.getText();
            if(texts.contains(confMessage)) {
                System.out.println("Conf Message is verified");
            }
        }
	   
//   Assert.assertEquals(confMessage, "Dear Ankit Bajaj,\r\n"
//   		+ "\r\n"
//   		+ "Your personal settings have been registered.");
	
	}
    @Test
	@Then("User Clicks on Next button")
	public void user_Clicks_on_Next_button() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//*[@id=\"form_register\"]/fieldset/button")).click();
	}
    @Test
	@Then("User clicks on username and selects profile option")
	public void user_clicks_on_username_and_selects_profile_option() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//*[@id=\"menuone\"]/ul[2]/li[1]/a")).click();
	    driver.findElement(By.linkText("Profile")).click();
	}
    @Test
	@Then("User clicks on messages link")
	public void user_clicks_on_messages_link() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//li[@class=\"messages-icon \"]/a")).click();
	}
    @Test
	@Then("User clicks on compose message link")
	public void user_clicks_on_compose_message_link() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[@class=\"col-md-6\"]/a")).click();
	}
    @Test
	@Then("User fills up the compose message details")
	public void user_fills_up_the_compose_message_details(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<List<String>> rows = dataTable.asLists(String.class);
		
		 for (List<String> columns : rows) {
//		        store.addBook(new Book(columns.get(0), columns.get(1)));
		    	driver.findElement(By.xpath("//*[@id=\"compose_message\"]/fieldset/div[2]/div[1]/input")).sendKeys(columns.get(0));
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,350)", "");
				
				
				
		    }
		
	}
    @Test
	@Then("User clicks on Send Message")
	public void user_clicks_on_Send_Message() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.cssSelector("#compose_message > fieldset > div:nth-child(6) > div.col-sm-8 > button")).submit();;
	   
	}
//    @After
//    public void closing_Browser() {
//    	driver.close();
//    }



}