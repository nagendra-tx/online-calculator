package stepDefinitions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import calc.xendit_qa_assessment.CalcAction;

import org.testng.AssertJUnit;
import java.util.List;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import resources.Base;
import resources.TestImage;
import resources.Utility;
import io.cucumber.datatable.DataTable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import org.testng.annotations.Test;
@Test

@RunWith(Cucumber.class)
public class StepDefinition extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Given("^Open chrome browser and start application$")
	public void open_chrome_browser_and_start_application() throws Throwable {
		driver = initializaDriver();
		log.info("driver is initialized");

		driver.get(prop.getProperty("url"));
		log.info("navigate to calc page");
	}

	@When("^I enter following values and press CE button$")
	public void i_enter_following_values_and_press_ce_button(List<List<String>> dataTable) throws Throwable {
		// Create your table as below (notice- dataTable declared as- List<List<String>>
		// in method argument above)
		DataTable data = DataTable.create(dataTable);
		CalcAction.performCalculation(driver, data);
		log.info("values are entered and operator action performed");

	}

	@Then("^I should be able to see$")
	public void i_should_be_able_to_see(List<List<String>> dataTable) throws Throwable {

		DataTable data = DataTable.create(dataTable);
		String expectedValue = data.cell(0, 1).trim();
		
		System.out.println("Expected Value: " + data.cell(0, 1));

		try {
			// Here we are capturing screenshot and performing cropping to get result area
			// we are using OCR to get text from captured screen and do matching here
			WebElement ele = driver.findElement(By.id("canvas"));
			String capturedPath = Utility.captureScreenshot(driver, ele);
			
			log.info("Screenshot captured, cropped and stored in project directory");
			Thread.sleep(1000);
			String textData = TestImage.getTextFromImage(capturedPath);
			System.out.println("Actual Value: " + textData.trim());

			AssertJUnit.assertEquals(textData.trim(), expectedValue);
			
			Thread.sleep(1000);
			
			

		} catch (Exception e) {
			System.out.println("Nothing to do with it");
		}
	}
	
	@BeforeMethod
	public void beforeScenario() 
	{
	     //
	}
	
	@AfterMethod
	public void afterScenario() 
	{
		driver.close();
		driver.quit();
	}

}
