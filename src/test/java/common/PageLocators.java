package common;

import org.openqa.selenium.By;

public class PageLocators {

    public static final By COOKIE_BUTTON = org.openqa.selenium.By.id("cookies-read-more-link");
    public static final By COUNTRY_DROPDOWN = org.openqa.selenium.By.id("country");
    public static final By STATE_DROPDOWN = org.openqa.selenium.By.id("____state_linked_select");
    public static final By BUSINESS_ACCOUNT_RADIOBUTTON = org.openqa.selenium.By.id("register_type_of_account_business_form_input");
    public static final By PERSONAL_ACCOUNT_RADIOBUTTON = By.id("register_type_of_account_personal_form_input");
    public static final By EDUCATION_RADIOBUTTON = By.id("register_type_of_account_education_form_input");
    public static final By PRIVATE_BUSINESS_COMPANY_RADIOBUTTON = By.id("register_business_account_type_private_company_form_input");
    public static final By PUBLIC_BUSINESS_COMPANY_RADIOBUTTON = By.id("register_business_account_type_public_company_form_input");
    public static final By PARTNERSHIP_BUSINESS_COMPANY_RADIOBUTTON = By.id("register_business_account_type_partnership_form_input");
    public static final By TRUST_BUSINESS_COMPANY_RADIOBUTTON = By.id("register_business_account_type_trust_form_input");
    public static final By INDIVIDUAL_RADIOBUTTON = By.id("register_personal_account_type_individual_form_input");
    public static final By SOLE_TRADER_RADIOBUTTON = By.id("register_personal_account_type_sole_trader_form_input");
    public static final By PRIVATE_COMPANY_EDUCATION_RADIOBUTTON = By.id("register_education_account_type_private_company_form_input");
    public static final By PUBLIC_COMPANY_EDUCATION_RADIOBUTTON = By.id(("register_education_account_type_public_company_form_input"));
    public static final By ANNUAL_AMOUNT_FIELD = By.id("annual_equivalent_amount");
    public static final By COMPANY_NAME_FIELD = By.id("company_name");
    public static final By CURRENCY_DROPDOWN = By.id("annual_equivalent_amount_currency");
    public static final By FIRST_NAME_FIELD = By.id("first_name");
    public static final By LAST_NAME_FIELD = By.id("last_name");
    public static final By EMAIL_FIELD = By.id("email");
    public static final By DIALING_CODE_DROPDOWN = By.id("__pin_mobile_number_international_dialing_code");
    public static final By PHONE_FIELD = By.id("__pin_mobile_number_mobile_phone");
    public static final By TERMS_OF_USE_CHECKBOX = By.id("register_terms_of_use_agree_form_input");
    public static final By NEWSLETTER_CHECKBOX = By.id("register_newsletter_and_privacy_policy_agree_form_input");
    public static final By CAPTCHA_QUESTION = By.id("cal_captcha_f2462_question");
    public static final By REGISTER_BUTTON = By.id("register_button_subscribe_form_input");
    public static final By CAPTCHA_INPUT_FIELD = By.id("__calc_captcha_text");
    public static final By VERIFICATION_PAGE_HEADING = By.xpath("//div[@id='pages_content_252']//h1");
    public static final By NOT_SUPPORTED_COUNTRY_HEADING = By.xpath("//div[@id='pages_content_47816']//h2");
    public static final String XPATH_VALUE = "//option[@value='";

}
