package guvigu;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Guvipro {
	WebDriver driver;
	@BeforeClass
	public void Browsersetup() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}
	@Test
	public void Bookfee_registeration() throws IOException {
		
		WebElement findElement = driver.findElement(By.xpath("//a[text()='Click Here']"));
		System.out.println(findElement.getText());
		findElement.click();
		String title = driver.getTitle();
		System.out.println(title);
		for (String windowHandle:driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);			
		}
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();	
		WebElement findElement2 = driver.findElement(By.xpath("//div//h3"));
		String expectedresult="New Window";
		String text = findElement2.getText();
		System.out.println(findElement2.getText());
		Assert.assertEquals("New Window", expectedresult);
		
	}
		
		
	@AfterClass
	public void browser_close() {
		// TODO Auto-generated method stub
        driver.quit();
	}

	

}
