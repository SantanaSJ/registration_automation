package actions;

import browser.BrowserException;
import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegisterPage;
import steps.Helper;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageActions {

    private RegisterPage registerPage;
    private WebDriver driver = Driver.getDriver();
    private Actions actions;
    private Select selectDropdown;
    private Helper helper;


    public PageActions(RegisterPage registerPage, Helper helper) throws BrowserException {
        this.registerPage = registerPage;
        this.helper = helper;
        this.actions = new Actions(driver);
    }

    public void clickAcceptCookies() {
        registerPage.cookieButton().click();
    }

    public void clickDropdown() {
        registerPage.countryDropdown().click();
    }

    public void selectBusinessAccount() {
        registerPage.businessAccountRadioButton().click();
    }

    public void selectPersonalAccount() {
        registerPage.personalAccountRadioButton().click();
    }

    public void selectEducation() {
        registerPage.educationRadioButton().click();
    }

    public void selectBusinessPrivateCompany() {
        registerPage.privateBusinessCompanyRadioButton().click();
    }

    public void selectBusinessPublicCompany() {
        registerPage.publicBusinessCompanyRadioButton().click();
    }

    public void selectBusinessPartnership() {
        actions.scrollByAmount(0, 200).perform();
        registerPage.partnershipBusinessCompanyRadioButton().click();
    }

    public void selectBusinessTrust() {
        actions.scrollByAmount(0, 200).perform();
        registerPage.trustBusinessCompanyRadioButton().click();
    }

    public void selectIndividual() {
        registerPage.individualRadioButton().click();
    }

    public void selectSoleTrader() {
        registerPage.soleTraderRadioButton().click();
    }

    public void selectEducationPrivateCompany() {
        actions.scrollByAmount(0, 200).perform();
        registerPage.privateCompanyEducationRadioButton().click();
    }

    public void selectEducationPublicCompany() {
        actions.scrollByAmount(0, 200).perform();
        registerPage.publicCompanyEducationRadioButton().click();
    }

    public HashMap<String, Integer> getRandomCountries() {
        selectDropdown = new Select(registerPage.countryDropdown());

        //option[contains(.,'- - - - - - - - - - - - - - - - - - - -')]
        //option[@value='236'][contains(.,'United Kingdom')]

        HashMap<String, Integer> countriesMap = new HashMap<>();
        List<WebElement> countriesOptions = selectDropdown.getOptions();
        Collections.shuffle(countriesOptions);
        for (int i = 1; i < 3; i++) {
            WebElement option = countriesOptions.get(i);
            String value = option.getAttribute("value");
            String countryText = option.getText();
            boolean isUnsupported = helper.isSupported(countryText);
            if (isUnsupported || countryText.contains("- - - - - - - - - - - - - - - - - - - -")) {
                continue;
            }
            if (!value.isEmpty() && !countryText.isEmpty()) {
                countriesMap.put(countryText, Integer.parseInt(value));
                break;
            }
        }
        return countriesMap;
    }

    public void selectRandomCountry(int loop) {
        HashMap<String, Integer> randomCountries = getRandomCountries();

        for (int i = 0; i < loop; i++) {
            for (Map.Entry<String, Integer> country : randomCountries.entrySet()) {
                Integer countryValue = country.getValue();

                WebElement selectedCountryElement = registerPage.selectedCountryXpath(countryValue, country.getKey());
                selectedCountryElement.click();

                //____state_linked_select
                //option[@value='4'][contains(.,'Arkansas')]
                if (registerPage.stateDropdown().isDisplayed()) {
                    registerPage.stateDropdown().click();
                    selectDropdown = new Select(registerPage.stateDropdown());
                    List<WebElement> stateOptions = selectDropdown.getOptions();
                    Collections.shuffle(stateOptions);

                    WebElement option = stateOptions.get(0);
                    String stateValue = option.getAttribute("value");
                    String stateText = option.getText();

                    if (!stateValue.isEmpty() && !stateText.isEmpty()) {
                        WebElement selectedStateElement = registerPage.selectedStateXpath(Integer.parseInt(stateValue), stateText);
                        selectedStateElement.click();
                    }
                }
                helper.setCountry(country.getKey());
                break;
            }
            break;
        }
    }


    public void companyName(String name) {
        registerPage.companyNameField().sendKeys(name);
    }

    //    !!
    public void clickCurrencyDropdown() {
        actions.scrollByAmount(0, 300).perform();
        registerPage.currencyDropdown().click();
    }

    public void setCurrency(String currency) {
        Select dropdown = new Select(registerPage.currencyDropdown());
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(currency)) {
                option.click();
                actions.scrollByAmount(0, 300).perform();
                break;
            }
        }
    }

    public void annualAmount(String annualAmount) {
        registerPage.annualAmountField().sendKeys(annualAmount);
    }

    public void firstName(String firstName) {
        registerPage.firstName().sendKeys(firstName);
    }

    public void lastName(String lastName) {
        registerPage.lastName().sendKeys(lastName);
    }

    public void emailAddress(String workEmailAddress) {
        registerPage.workEmailAddress().sendKeys(workEmailAddress);
    }

    public void clickDialingCodes() {
        registerPage.dialingCode().click();
    }

    public void setCode(String countryCode) {
        Select dropdown = new Select(driver.findElement(By.id("__pin_mobile_number_international_dialing_code")));
//option[@value='bg 359'][contains(.,'Bulgaria +359')]
        List<WebElement> allSelectedCodes = dropdown.getOptions();
        for (int i = 1; i < allSelectedCodes.size(); i++) {
            WebElement option = allSelectedCodes.get(i);
            String[] split = option.getText().split("\\s");
            String lastElement = split[split.length - 1];

            if (lastElement.equals(countryCode)) {
                option.click();
                actions.scrollByAmount(0, 200).perform();
                break;
            }
        }
    }

    public void phone(String phone) {
        registerPage.phone().sendKeys(phone);
    }

    public void clickTermsOfUse() {
        registerPage.termsOfUseCheckBox().click();
    }

    public void clickNewsletter() {
        registerPage.newsLetterCheckBox().click();
    }

    public String calculateCaptcha() {
        WebElement webElement = registerPage.captchaQuestion();
        String text = webElement.getText();
        String[] split = text.split("\\s+");
        String result = "";
        int num1 = 0;
        int num2 = 0;
        String operator = "";

//        handle two digits
        if (split.length == 4) {
            num1 = Integer.parseInt(split[0]);
            num2 = Integer.parseInt(split[2]);
            operator = split[1];
        } else if (split.length == 5) {
            char ch1 = split[1].charAt(0);
            if (Character.isDigit(ch1)) {
                num1 = Integer.parseInt(split[0] + split[1]);
                num2 = Integer.parseInt(split[3]);
                operator = split[2];
            } else if (Character.isDigit(split[3].charAt(0))){
                num1 = Integer.parseInt(split[2] + split[3]);
                num2 = Integer.parseInt(split[0]);
                operator = split[1];
            }
        } else if (split.length == 6) {
            num1 = Integer.parseInt(split[0] + split[1]);
            num2 = Integer.parseInt(split[3] + split[4]);
            operator = split[2];
        }
        switch (operator) {
            case "+" -> result = String.valueOf(num1 + num2);
            case "-" -> result = String.valueOf(num1 - num2);
            case "*" -> result = String.valueOf(num1 * num2);
            case "/" -> result = String.valueOf(num1 / num2);
        }
        return result;
    }

    public void answerCaptcha(String answer) {
        registerPage.captchaInput().sendKeys(answer);
    }

    public void clickRegisterButton() {
        registerPage.registerButton().click();
    }

    public String getVerificationPageHeading() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(registerPage.verificationPageHeading()));
        String text = registerPage.verificationPageHeading().getText();
        System.out.println();
        return text;
    }

    public WebElement getNotSupportedError() {
       return registerPage.notSupportedCounty();
    }
}
