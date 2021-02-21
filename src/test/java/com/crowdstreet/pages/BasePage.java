package com.crowdstreet.pages;

import com.crowdstreet.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {


    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath ="//div[@class='tablet-menu css-eullop']//a[2]")
    protected WebElement createAccountLink;


    // CreateAnAccount link is Overlay by another webElement
    // JavaScriptExecutor will help resolve this problem
    public void createAnAccountClick(){
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", createAccountLink);

    }







}
