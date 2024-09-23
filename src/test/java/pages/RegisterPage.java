package pages;

import common.PageLocators;
import driver.Driver;
import browser.BrowserException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;

import static common.PageLocators.*;

public class RegisterPage {


    private WebDriver driver = Driver.getDriver();


    public RegisterPage() throws BrowserException {
    }

    public WebElement cookieButton() {

        return driver.findElement(COOKIE_BUTTON);
    }

    public WebElement countryDropdown() {
        return driver.findElement(COUNTRY_DROPDOWN);
    }

    public WebElement selectedCountryXpath(int value, String countryName) {
        By selectedCountryXpath = By.xpath( XPATH_VALUE + value + "'][contains(.,'" + countryName + "')]");
        return driver.findElement(selectedCountryXpath);
    }

    public WebElement stateDropdown() {
        
        return driver.findElement(STATE_DROPDOWN);
    }

    public WebElement selectedStateXpath(int value, String stateName) {
        return driver.findElement(By.xpath(XPATH_VALUE + value + "'][@value='" + stateName + "']"));
    }

    public WebElement businessAccountRadioButton() {
        return driver.findElement(BUSINESS_ACCOUNT_RADIOBUTTON);
    }

    public WebElement personalAccountRadioButton() {
        return driver.findElement(PERSONAL_ACCOUNT_RADIOBUTTON);
    }

    public WebElement educationRadioButton() {
        
        return driver.findElement(EDUCATION_RADIOBUTTON);
    }

    public WebElement privateBusinessCompanyRadioButton() {

        return driver.findElement(PRIVATE_BUSINESS_COMPANY_RADIOBUTTON);
    }

    public WebElement publicBusinessCompanyRadioButton() {

        return driver.findElement(PUBLIC_BUSINESS_COMPANY_RADIOBUTTON);
    }

    public WebElement partnershipBusinessCompanyRadioButton() {
        return driver.findElement(PARTNERSHIP_BUSINESS_COMPANY_RADIOBUTTON);
    }

    public WebElement trustBusinessCompanyRadioButton() {
        return driver.findElement(TRUST_BUSINESS_COMPANY_RADIOBUTTON);
    }

    public WebElement individualRadioButton() {
        return driver.findElement(INDIVIDUAL_RADIOBUTTON);
    }

    public WebElement soleTraderRadioButton() {

        return driver.findElement(SOLE_TRADER_RADIOBUTTON);
    }

    public WebElement privateCompanyEducationRadioButton() {
        return driver.findElement(PRIVATE_COMPANY_EDUCATION_RADIOBUTTON);
    }

    public WebElement publicCompanyEducationRadioButton() {
        return driver.findElement(PUBLIC_COMPANY_EDUCATION_RADIOBUTTON);
    }

    public WebElement companyNameField() {
        return driver.findElement(COMPANY_NAME_FIELD);
    }

    public WebElement annualAmountField() {

        return driver.findElement(ANNUAL_AMOUNT_FIELD);
    }

    public WebElement currencyDropdown() {
        return driver.findElement(CURRENCY_DROPDOWN);
    }

    public WebElement firstName() {
        return driver.findElement(FIRST_NAME_FIELD);
    }

    public WebElement lastName() {

        return driver.findElement(LAST_NAME_FIELD);
    }

    public WebElement workEmailAddress() {
        return driver.findElement(EMAIL_FIELD);
    }

    public WebElement dialingCode() {
        return driver.findElement(DIALING_CODE_DROPDOWN);
    }

    public WebElement phone() {
        return driver.findElement(PHONE_FIELD);
    }

    public WebElement termsOfUseCheckBox() {
        return driver.findElement(TERMS_OF_USE_CHECKBOX);
    }

    public WebElement newsLetterCheckBox() {
        return driver.findElement(NEWSLETTER_CHECKBOX);
    }

    public WebElement captchaQuestion() {
        return driver.findElement(CAPTCHA_QUESTION);
    }

    public WebElement registerButton() {
        return driver.findElement(REGISTER_BUTTON);
    }


    public WebElement captchaInput() {
        return driver.findElement(CAPTCHA_INPUT_FIELD);
    }

    public WebElement verificationPageHeading() {
        return driver.findElement(VERIFICATION_PAGE_HEADING);
    }

    public WebElement notSupportedCounty() {
        return driver.findElement(NOT_SUPPORTED_COUNTRY_HEADING);
    }
}
