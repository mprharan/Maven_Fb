package com.stepdefinition;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Maven_Facebook.BaseClass_fb;
import com.Maven_Facebook.DataDriven1;
import com.runnerclass.Runner_Class;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step_Definition extends BaseClass_fb {
	public static WebDriver d = Runner_Class.d;

	@Given("User Launch The Application")
	public void user_launch_the_application() {
		launchUrl("https://www.facebook.com/");
		implicitlyWait();
	}

	@When("User print The Banner")
	public void user_print_the_banner() {
		WebElement a = d.findElement(By.cssSelector("._8eso"));
		System.out.println(getText(a));
	}

	@When("Enter The Username")
	public void enter_the_username() throws IOException {
		WebElement b = d.findElement(By.cssSelector("#email"));
		String b1 = DataDriven1.singleDataValue("Sheet2", 0, 0);
		userInput(b, b1);
	}

	@When("Enter The Password")
	public void enter_the_password() throws IOException {
		WebElement c = d.findElement(By.xpath("//*[@type='password']"));
		String c1 = DataDriven1.singleDataValue("Sheet2", 1, 0);
		userInput(c, c1);
	}

	@When("Click The Login It Verify The User Take Scs")
	public void click_the_login_it_verify_the_user_take_scs() throws InterruptedException, IOException {
		WebElement d1 = d.findElement(By.xpath("//*[@type='submit']"));
		clickOnElement(d1);
		sleep();
		capture("FbMavenLogin");
		sleep();

	}

	@When("User Navigate Back Creates New Account")
	public void user_navigate_back_creates_new_account() throws InterruptedException {

		navigateBack();
		sleep();
		WebElement e = d.findElement(By.xpath("(//*[@role='button'])[2]"));
		clickOnElement(e);
	}

	@When("Enter The Firstname")
	public void enter_the_firstname() throws IOException {

		WebElement f = d.findElement(By.xpath("//*[@name='firstname']"));
		String f1 = DataDriven1.singleDataValue("Sheet2", 2, 0);
		userInput(f, f1);
	}

	@When("Enter The Lastname")
	public void enter_the_lastname() throws IOException {
		WebElement g = d.findElement(By.xpath("//*[@name='lastname']"));
		String g1 = DataDriven1.singleDataValue("Sheet2", 3, 0);
		userInput(g, g1);
	}

	@When("Enter The Email")
	public void enter_the_email() throws InterruptedException, IOException {
		WebElement h = d.findElement(By.xpath("//*[@name='reg_email__']"));
		String h1 = DataDriven1.singleDataValue("Sheet2", 4, 0);
		userInput(h, h1);
		WebElement i = d.findElement(By.xpath("//*[@name='reg_passwd__']"));
		String i1 = DataDriven1.singleDataValue("Sheet2", 5, 0);
		userInput(i, i1);
		sleep();
	}

	@When("Select Birthday From Dropdown")
	public void select_birthday_from_dropdown() throws InterruptedException {
		WebElement drop = d.findElement(By.xpath("//*[@name='birthday_day']"));
		//Select s = new Select(drop);
		//s.selectByValue("19");
	dropDownSelect("value", drop, "19");
		sleep();
	}

	@When("Select Birthmonth From Dropdown")
	public void select_birthmonth_from_dropdown() throws InterruptedException {

		WebElement drop1 = d.findElement(By.xpath("//*[@name='birthday_month']"));
//		Select s1 = new Select(drop1);
//		s1.selectByValue("5");
		dropDownSelect("value", drop1, "5");
		sleep();
	}

	@When("Select Birthyear From Dropdown")
	public void select_birthyear_from_dropdown() {
		WebElement drop2 = d.findElement(By.xpath("//*[@name='birthday_year']"));
//		Select s2 = new Select(drop2);
//		s2.selectByValue("1999");
		dropDownSelect("value", drop2, "1999");

	}

	@When("Click The Gender")
	public void click_the_gender() {
		WebElement j = d.findElement(By.xpath("(//*[@value='2'])[3]"));
		clickOnElement(j);
	}

	@When("Click Create Account")
	public void click_create_account() throws InterruptedException {

		WebElement k = d.findElement(By.xpath("(//*[@type='submit'])[2]"));
		clickOnElement(k);
		sleep();

	}

	@Then("Take Scs Of The Error Page")
	public void take_scs_of_the_error_page() throws IOException {
		capture("FbMavenCreate");

	}
}
