package org.alertprgmdemo;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;


public class Alertprgm {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		//simple alert
		Alert simplealert=driver.switchTo().alert();
		Thread.sleep(2000);
		String alertText=simplealert.getText();
		System.out.println("Simple alert Text:"+alertText);
		simplealert.accept();
		
		TakesScreenshot srcshot=(TakesScreenshot)driver;
		File src=srcshot.getScreenshotAs(OutputType.FILE);
		File des=new File("\"C:\\org.alertprgmdemo\\snap1\\");
        FileHandler.copy(src, des);

		
		
		//confirmation alert
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		Alert confirmationalert=driver.switchTo().alert();
		Thread.sleep(2000);
		String confirmationText=confirmationalert.getText();
		System.out.println("Confirmation alert Text:"+alertText);
		confirmationalert.dismiss();
		TakesScreenshot srcshot1=(TakesScreenshot)driver;
		File src1=srcshot1.getScreenshotAs(OutputType.FILE);
		File des1=new File("\"C:\\org;.alertprgmdemo\\snap3\\");
		FileHandler.copy(src1, des1);

		
		
		//prompt alert
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Alert promptalert=driver.switchTo().alert();
		Thread.sleep(2000);
		String promptText=promptalert.getText();
		promptalert.sendKeys("Welcome to alert message");
		promptalert.accept();
		 TakesScreenshot srcshot2=(TakesScreenshot)driver;
			File src2=srcshot2.getScreenshotAs(OutputType.FILE);
			File des2=new File("\"C:\\org.alertprgmdemo\\snap4\"");
		    FileHandler.copy(src2, des2);
		 System.out.println(driver.findElement(By.id("result")).getText());
		
		    driver.quit();
		    
		
		
		
		
		
		
		
		

	}

}
