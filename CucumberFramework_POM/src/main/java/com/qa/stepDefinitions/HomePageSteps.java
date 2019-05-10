package com.qa.stepDefinitions;

import org.junit.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageSteps extends TestBase {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Given("^user opens browser$")
	public void user_opens_browser() {
		TestBase.initialization();
	}

	@Then("^user is on login Page$")
	public void user_is_on_login_Page() {
		loginPage = new LoginPage();
		String title = loginPage.validatePageTitle();
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", title);
	}

	@Then("^user logs into app$")
	public void user_logs_into_app() {
		homePage = loginPage.login();
	}

	@Then("^validate logged in username$")
	public void validate_home_page_title() {
		String homeTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals("CRMPRO", homeTitle);
	}

}
