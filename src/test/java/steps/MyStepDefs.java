package steps;

import actions.PageActions;
import com.github.javafaker.Faker;
import driver.Driver;
import browser.BrowserException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.RegisterPage;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyStepDefs {

    private final PageActions pageActions;
    private final RegisterPage registerPage;
    private final Helper helper;
    //    private String country;
    private final Faker faker = new Faker();

    private final WebDriver driver = Driver.getDriver();

    public MyStepDefs(PageActions pageActions, RegisterPage registerPage, Helper helper) throws BrowserException {
        this.pageActions = pageActions;
        this.registerPage = registerPage;
        this.helper = helper;
    }

    @Given("I am on register page {string}")
    public void iAmOnRegisterPage(String page) {
        driver.get(page);
        driver.manage().window().maximize();
        driver.navigate().refresh();
    }

    @And("I click on I accept cookies button")
    public void iClickOnIAcceptCookiesButton() {
        if (registerPage.cookieButton().isDisplayed()) {
            pageActions.clickAcceptCookies();
            System.out.println();
        }
    }

    @Given("I am a user from a random country {int}")
    public void iAmAUserFromARandomCountryIterate(int loop) {
        pageActions.clickDropdown();
        pageActions.selectRandomCountry(loop);
    }


    @And("I want to create an online {string} {string}")
    public void iWantToCreateAnOnline(String accountType, String subType) {

        if (accountType.equals("Business Account")) {
            pageActions.selectBusinessAccount();
            switch (subType) {
                case "Private Company" -> pageActions.selectBusinessPrivateCompany();
                case "Public Company" -> pageActions.selectBusinessPublicCompany();
                case "Partnership" -> pageActions.selectBusinessPartnership();
                default -> pageActions.selectBusinessTrust();
            }
        } else if (accountType.equals("Personal Account")) {
            pageActions.selectPersonalAccount();
            if (subType.equals("Individual")) {
                pageActions.selectIndividual();
            } else {
                pageActions.selectSoleTrader();
            }
        } else {
            pageActions.selectEducation();
            if (subType.equals("Private Company")) {
                pageActions.selectEducationPrivateCompany();
            } else {
                pageActions.selectEducationPublicCompany();
            }
        }
        helper.setSubType(subType);
    }

    @When("I fill in the registration form with valid data {string}, {string}, {string}, {string}, {string}, email, {string}, {string}")
    public void iFillInTheRegistrationFormWithValidData(String companyName, String currency, String annualAmount, String firstName, String lastName, String code, String phone) throws BrowserException {

        if (helper.getSubType().equals("Private Company") || helper.getSubType().equals("Public Company")
                || helper.getSubType().equals("Trust") || helper.getSubType().equals("Partnership")) {
            pageActions.companyName(companyName);
        }

        String email = faker.internet().emailAddress();

        pageActions.clickCurrencyDropdown();
        pageActions.setCurrency(currency);
        pageActions.annualAmount(annualAmount);
        pageActions.firstName(firstName);
        pageActions.lastName(lastName);
        pageActions.emailAddress(email);
        pageActions.clickDialingCodes();
        pageActions.setCode(code);
        pageActions.phone(phone);
    }

    @And("I tick the Terms of use checkbox")
    public void iTickTheTermsOfUseCheckbox() {
        pageActions.clickTermsOfUse();
        pageActions.clickNewsletter();
    }

    @And("I enter the captcha result")
    public void iEnterTheCaptchaResult() {
        pageActions.answerCaptcha(pageActions.calculateCaptcha());
    }

    @And("I click Register button")
    public void iClickRegisterButton() {
        pageActions.clickRegisterButton();
    }

    @Then("the page is redirected to Email and mobile verification page {string} with heading {string}")
    public void thePageIsRedirectedToEmailAndMobileVerificationPageWithHeading(String url, String heading) {
        String currentUrl = driver.getCurrentUrl();

        String[] splitUrl = currentUrl.split("=");
        if (splitUrl[1].equals("1")) {
            String text = pageActions.getNotSupportedError().getText();
            assertEquals("Sorry, we can't pay from " + helper.getCountry() + " yet!", text);
            System.out.println("Country to add: " + helper.getCountry());
//            helper.addCountry(helper.getCountry());
        } else {
                    assertAll("Assert successful page redirection",
                () -> assertEquals(url, currentUrl),
                () -> assertEquals(heading, pageActions.getVerificationPageHeading()));
        }
//            if (pageActions.getNotSupportedError().isDisplayed()) {
//            }

    }
}
