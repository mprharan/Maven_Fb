package com.testng;

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
import org.testng.annotations.Test;

import com.Maven_Facebook.DataDriven1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_Testng {
	public static WebDriver d = null;

	@Test(priority = 0, groups = "login")
	private void Browser_Launch() {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.facebook.com/");
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1, groups = "login")
	private void Print_Banner() {
		WebElement a = d.findElement(By.cssSelector("._8eso"));
		System.out.println(a.getText());
	}

	@Test(priority = 2, groups = "login")
	private void Username() throws IOException {
		WebElement b = d.findElement(By.cssSelector("#email"));
		// b.sendKeys("9584623515");
		String b1 = DataDriven1.singleDataValue("Sheet2", 0, 0);
		b.sendKeys(b1);
	}

	@Test(priority = 3, groups = "login")
	private void Password() throws IOException {
		WebElement c = d.findElement(By.xpath("//*[@type='password']"));
//		c.sendKeys("abcdefgh");
		String c1 = DataDriven1.singleDataValue("Sheet2", 1, 0);
		c.sendKeys(c1);
	}

	@Test(priority = 4, groups = "login")
	private void Scs() throws IOException, InterruptedException {
		WebElement d1 = d.findElement(By.xpath("//*[@type='submit']"));
		d1.click();

		Thread.sleep(5000);
		TakesScreenshot scs = (TakesScreenshot) d;
		File screenshotAs = scs.getScreenshotAs(OutputType.FILE);
		File destination = new File("D:\\Selenium scs\\FBmaventestnglogin.png");
		FileHandler.copy(screenshotAs, destination);
		Thread.sleep(3000);
	}

	@Test(priority = 5, groups = "login")
	private void New_Account() throws InterruptedException {
		d.navigate().back();
		Thread.sleep(3000);
		WebElement e = d.findElement(By.xpath("(//*[@role='button'])[2]"));
		e.click();
	}

	@Test(priority = 6, groups = "create")
	private void Firstname() throws IOException {
		WebElement f = d.findElement(By.xpath("//*[@name='firstname']"));
//		f.sendKeys("Hariharan");
		String f1 = DataDriven1.singleDataValue("Sheet2", 2, 0);
		f.sendKeys(f1);

	}

	@Test(priority = 7, groups = "create")
	private void Lastame() throws IOException {
		WebElement g = d.findElement(By.xpath("//*[@name='lastname']"));
//		g.sendKeys("Ramachandran");
		String g1 = DataDriven1.singleDataValue("Sheet2", 3, 0);
		g.sendKeys(g1);
	}

	@Test(priority = 8, groups = "create")
	private void Email() throws IOException {
		WebElement h = d.findElement(By.xpath("//*[@name='reg_email__']"));
//		h.sendKeys("9584");
		String h1 = DataDriven1.singleDataValue("Sheet2", 4, 0);
		h.sendKeys(h1);
	}

	@Test(priority = 9, groups = "create")
	private void Password1() throws IOException, InterruptedException {
		WebElement i = d.findElement(By.xpath("//*[@name='reg_passwd__']"));
//		i.sendKeys("abcdefghi");
		String i1 = DataDriven1.singleDataValue("Sheet2", 5, 0);
		i.sendKeys(i1);
		Thread.sleep(3000);
	}

	@Test(priority = 10, groups = "create")
	private void Birth_Day() throws InterruptedException {
		WebElement drop = d.findElement(By.xpath("//*[@name='birthday_day']"));
		Select s = new Select(drop);
		s.selectByValue("19");
		Thread.sleep(3000);
	}

	@Test(priority = 11, groups = "create")
	private void Birth_Month() throws InterruptedException {
		WebElement drop1 = d.findElement(By.xpath("//*[@name='birthday_month']"));
		Select s1 = new Select(drop1);
		s1.selectByValue("5");
		Thread.sleep(3000);
	}

	@Test(priority = 12, groups = "create")
	private void Birth_Year() {
		WebElement drop2 = d.findElement(By.xpath("//*[@name='birthday_year']"));
		Select s2 = new Select(drop2);
		s2.selectByValue("1999");
	}

	@Test(priority = 13, groups = "create")
	private void Gender() {
		WebElement j = d.findElement(By.xpath("(//*[@value='2'])[3]"));
		j.click();
	}

	@Test(priority = 14, groups = "create")
	private void Create_Account() throws InterruptedException {
		WebElement k = d.findElement(By.xpath("(//*[@type='submit'])[2]"));
		k.click();
		Thread.sleep(3000);
	}

	@Test(priority = 15, groups = "scs")
	private void Scs1() throws IOException, InterruptedException {
		TakesScreenshot scs1 = (TakesScreenshot) d;
		File ScreenshotAs = scs1.getScreenshotAs(OutputType.FILE);
		File Destination = new File("D:\\Selenium scs\\FBmaventestngcreate.png");
		FileHandler.copy(ScreenshotAs, Destination);
		Thread.sleep(2000);
		d.close();
	}
}
