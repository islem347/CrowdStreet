package com.crowdstreet.pages;

import com.crowdstreet.utilities.ConfigurationReader;
import com.crowdstreet.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;


public class CreateAnAccountPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

    @FindBy(xpath = "//span[@class='title']")
    private WebElement signupWithMessage;

    @FindBy(id="create_account_email")
    private WebElement emailBox;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement firstNameBox;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    private WebElement lastNameBox;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement newPasswordBox;

    @FindBy(xpath = "(//input[@type='password'])[3]")
    private WebElement confirmPasswordBox;

    @FindBy(xpath = "(//input[@type='text'])[5]")
    private WebElement phoneNumberBox;

    @FindBy(xpath = "(//input[@type='text'])[6]")
    private WebElement streetAddressBox;

    @FindBy(xpath = "(//input[@type='text'])[7]")
    private WebElement cityBox;

    @FindBy(xpath = "(//input[@type='text'])[8]")
    private WebElement stateDropdown;

    @FindBy(xpath = "(//input[@type='text'])[9]")
    private WebElement zipCodeBox;

    @FindBy(xpath = "(//input[@type='text'])[10]")
    private WebElement countryDropdown ;

    @FindBy(xpath = "//label[@class='_field_e1a40'][1]")
    public WebElement accreditedInvestorCheckbox;

    @FindBy(xpath = "(//div[@class='_check_1fb41'])[1]")
    public WebElement termOfServiceCheckBox;

    @FindBy(xpath = "(//label[@class='_field_1fb41 css-1mom10 e4yer9o0'])[2]")
    public WebElement understandCheckBox;

    @FindBy(xpath = "(//div[@class='recaptcha-container']//iframe)[1]")
    private WebElement captchaIframe;

   // @FindBy(css = "div.recaptcha-checkbox-checkmark")
    @FindBy(id="recaptcha-anchor-label")
    private WebElement captchaCheckBox;

    @FindBy(xpath = "(//a[.='Sign In'])[4]")
    private WebElement alreadyHaveAnAccountSignInText;

    @FindBy(xpath = "//button[.='Sign Up']")
    private WebElement signUpButton;

    @FindBy(xpath = "//h2[.='Congrats, ']")
    private WebElement congratsMessage;

    @FindBy(className = "message font-size--xsm text-align--center")
    private WebElement confirmationMessage;

    @FindBy(xpath = "(//span[@class='button-title font-size--xsm font-weight--bold'])[2]")
    private WebElement completeMyProfileButton;



    public String CreateAnAccountMessage(){
        wait.until(ExpectedConditions.visibilityOf(signupWithMessage));
         return signupWithMessage.getText();
    }

    JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

    public void enterCredential(){
        Faker faker = new Faker();
        emailBox.sendKeys(faker.internet().emailAddress());
        firstNameBox.sendKeys(faker.name().firstName());
        lastNameBox.sendKeys(faker.name().lastName());
        newPasswordBox.sendKeys(ConfigurationReader.getProperty("newUserPassword"));

        confirmPasswordBox.sendKeys(ConfigurationReader.getProperty("newUserPassword"));
        phoneNumberBox.sendKeys(faker.phoneNumber().cellPhone());
        streetAddressBox.sendKeys(faker.address().streetAddress());
        cityBox.sendKeys(faker.address().city());
        stateDropdown.sendKeys(faker.address().state());
        zipCodeBox.sendKeys(faker.address().zipCode());

        accreditedInvestorCheckbox.click();

        termOfServiceCheckBox.click();

        // scroll down - the page is not fully visible

        //js.executeScript("window.scrollBy(2000, 4000)");
        js.executeScript("arguments[0].scrollIntoView(true)", alreadyHaveAnAccountSignInText);

        wait.until(ExpectedConditions.visibilityOf(understandCheckBox));
        understandCheckBox.click();


    }

    // switch the driver to iframe where captcha box is located
    public void captchaHandle(){
        //js.executeScript("window.scrollBy(2000, 4000)");
        Driver.getDriver().switchTo().frame(captchaIframe);
        //js.executeScript("arguments[0].click;",captchaCheckBox);

        captchaCheckBox.click();

        Driver.getDriver().switchTo().defaultContent();
    }

    public void signUpButtonClick(){
        signUpButton.click();
    }

    /*
    public String getConfirmationMessage(){
        wait.until(ExpectedConditions.visibilityOf(congratsMessage));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(congratsMessage).perform();
        return congratsMessage.getText();
    }

     */

    public void completeProfileButtonClick(){
        wait.until(ExpectedConditions.visibilityOf(completeMyProfileButton));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(completeMyProfileButton ).click(completeMyProfileButton ).perform();


    }








}
