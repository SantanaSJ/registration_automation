Feature: Register functionality
  As an unregistered user I want to create an online account

  Background:
    Given I am on register page "https://register.io/en/register.asp?"
    And I click on I accept cookies button

  @Valid
  Scenario Outline: Successful registration for an online private company business account
    And I am a user from a random country <iterate>
    And I want to create an online "<account type>" "<sub type>"
    When I fill in the registration form with valid data "MyTestCompanyName", "EUR", "10000", "Vincent", "Shelby", email, "+359", "885574638"
    And I tick the Terms of use checkbox
    And I enter the captcha result
    And I click Register button
    Then the page is redirected to Email and mobile verification page "https://www.register.io/en/register_mail_verification.html?frwd_frb_country=0" with heading "Please check your mail"

    Examples:
   | account type     | sub type        | iterate |
   | Business Account | Private Company | 1       |
   | Business Account | Public Company  | 2       |
   | Business Account | Partnership     | 3       |
   | Business Account | Trust           | 4       |
   | Personal Account | Individual      | 5       |
   | Personal Account | Sole Trader     | 6       |
   | Education        | Private Company | 7       |
   | Education        | Public Company  | 8       |

#  @Valid
#  Scenario Outline: Unsuccessful registration with unsupported country
#    And I am a user from a random "<unsupportedCountry>" <iterate>
#    And I want to create an online "<account type>" "<sub type>"
#    When I fill in the registration form with valid data "MyTestCompanyName", "EUR", "10000", "Vincent", "Shelby", email, "+359", "885574638"
#    And I tick the Terms of use checkbox
#    And I enter the captcha result
#    And I click Register button
#    Then the page is redirected to Email and mobile verification page "https://www.register.io/en/register_mail_verification.html?frwd_frb_country=1" with error heading
#
#    Examples:
#      | account type     | sub type        | iterate |
#      | Business Account | Private Company | 1       |
#      | Business Account | Public Company  | 2       |
#      | Business Account | Partnership     | 3       |
#      | Business Account | Trust           | 4       |
#      | Personal Account | Individual      | 5       |
#      | Personal Account | Sole Trader     | 6       |
#      | Education        | Private Company | 7       |
#      | Education        | Public Company  | 8       |
