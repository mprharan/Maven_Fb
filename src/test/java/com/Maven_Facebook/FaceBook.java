package com.Maven_Facebook;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class FaceBook {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sony\\eclipse-workspace\\Mini_Project\\Driver\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("https://www.facebook.com/");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement a = d.findElement(By.cssSelector("._8eso"));
		System.out.println(a.getText());

		WebElement b = d.findElement(By.cssSelector("#email"));
		//b.sendKeys("9584623515");
		String b1 = DataDriven1.singleDataValue("Sheet2", 0, 0);
		b.sendKeys(b1);

		WebElement c = d.findElement(By.xpath("//*[@type='password']"));
//		c.sendKeys("abcdefgh");
		String c1 = DataDriven1.singleDataValue("Sheet2", 1, 0);
		c.sendKeys(c1);

		WebElement d1 = d.findElement(By.xpath("//*[@type='submit']"));
		d1.click();
		
		Thread.sleep(5000);
		TakesScreenshot scs = (TakesScreenshot) d;
		File screenshotAs = scs.getScreenshotAs(OutputType.FILE);
		File destination = new File("D:\\Selenium scs\\FBlogin.png");
		FileHandler.copy(screenshotAs, destination);

		Thread.sleep(3000);
		d.navigate().back();
		Thread.sleep(3000);

		WebElement e = d.findElement(By.xpath("(//*[@role='button'])[2]"));
		e.click();

		WebElement f = d.findElement(By.xpath("//*[@name='firstname']"));
//		f.sendKeys("Hariharan");
		String f1 = DataDriven1.singleDataValue("Sheet2", 2, 0);
		f.sendKeys(f1);

		WebElement g = d.findElement(By.xpath("//*[@name='lastname']"));
//		g.sendKeys("Ramachandran");
		String g1 = DataDriven1.singleDataValue("Sheet2", 3, 0);
		g.sendKeys(g1);

		WebElement h = d.findElement(By.xpath("//*[@name='reg_email__']"));
//		h.sendKeys("9584");
		String h1 = DataDriven1.singleDataValue("Sheet2", 4, 0);
		h.sendKeys(h1);

		WebElement i = d.findElement(By.xpath("//*[@name='reg_passwd__']"));
//		i.sendKeys("abcdefghi");
		String i1 = DataDriven1.singleDataValue("Sheet2", 5, 0);
		i.sendKeys(i1);
		Thread.sleep(3000);
		
		WebElement drop = d.findElement(By.xpath("//*[@name='birthday_day']"));
		Select s = new Select(drop);
		s.selectByValue("19");
		Thread.sleep(3000);
		
		WebElement drop1 = d.findElement(By.xpath("//*[@name='birthday_month']"));
		Select s1 = new Select(drop1);
		s1.selectByValue("5");
		Thread.sleep(3000);


		WebElement drop2 = d.findElement(By.xpath("//*[@name='birthday_year']"));
		Select s2 = new Select(drop2);
		s2.selectByValue("1999");

		WebElement j = d.findElement(By.xpath("(//*[@value='2'])[3]"));
		j.click();

		WebElement k = d.findElement(By.xpath("(//*[@type='submit'])[2]"));
		k.click();
		Thread.sleep(3000);

		TakesScreenshot scs1 = (TakesScreenshot) d;
		File ScreenshotAs = scs1.getScreenshotAs(OutputType.FILE);
		File Destination = new File("D:\\Selenium scs\\FBcreate.png");
		FileHandler.copy(ScreenshotAs, Destination);
	}
}
