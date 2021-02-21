package com.crowdstreet.step_definitions;

import com.crowdstreet.pages.CreateAnAccountPage;
import com.crowdstreet.utilities.ConfigurationReader;
import com.crowdstreet.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class CreateAnAccount_stepDefinition {


    CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    @Given("user on the landing page")
    public void user_on_the_landing_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user clicks on create an account link")
    public void user_clicks_on_create_an_account_link() {
        createAnAccountPage.createAnAccountClick();
    }

    @Then("user should see {string} is displayed")
    public void user_should_see_message_is_displayed(String expected) {
        String actual = createAnAccountPage.CreateAnAccountTitle();
        Assert.assertTrue(expected.contains(actual));
    }

    @Then("the title contains {string}")
    public void the_title_contain(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }




    @When("user enters all valid credentials")
    public void user_enters_all_valid_credential() {
        createAnAccountPage.enterCredential();

    }


    @And("user check the captcha checkbox")
    public void userCheckTheCaptchaCheckbox() {
        createAnAccountPage.captchaHandle();
    }

    @And("user click on sign up button")
    public void userClickOnSignUpButton() {
        createAnAccountPage.signUpButtonClick();
    }



    @Then("user should be able to click on Complete My Profile Button")
    public void userShouldBeAbleToClickOnCompleteMyProfileButton() {

        createAnAccountPage.completeProfileButtonClick();
    }


    @And("user should access his profile successfully and title contains {string}")
    public void userShouldAccessHisProfileSuccessfullyAndTitleContains(String expectedInTitle) {
        wait.until(ExpectedConditions.titleContains(expectedInTitle));
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }
}
