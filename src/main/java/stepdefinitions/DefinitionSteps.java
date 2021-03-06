package stepdefinitions;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LanguagePage;
import pages.ProductPage;
import pages.RegistrationPage;
import pages.SearchResultPage;
import pages.SignInPage;

public class DefinitionSteps {

  private static final long DEFAULT_TIMEOUT = 75;


  WebDriver driver;
  PageFactoryManager pageFactoryManager;
  HomePage homePage;
  SignInPage signInPage;
  LanguagePage languagePage;
  RegistrationPage registrationPage;
  SearchResultPage searchResultPage;
  ProductPage productPage;
  CheckoutPage checkoutPage;


  @Before
  public void testsSetUp() {
    chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    pageFactoryManager = new PageFactoryManager(driver);
  }

  @After
  public void tearDown() {
    driver.close();
  }

  @And("User opens {string} page")
  public void openPage(final String url) {
    homePage = pageFactoryManager.getHomePage();
    homePage.openHomePage(url);
  }


  @And("User checks search field visibility")
  public void userChecksSearchFieldVisibility() {
    homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    homePage.isSearchFieldVisible();
  }

  @And("User checks logo visibility")
  public void userChecksLogoVisibility() {
    homePage.isLogoVisible();
  }

  @And("User checks navigation menu visibility")
  public void userChecksNavigationMenuVisibility() {
    homePage.isNavigateMenuVisible();
  }

  @And("User checks sign in button visibility")
  public void userChecksSignInButtonVisibility() {
    homePage.isSignInButtonVisible();
  }

  @When("User clicks sign in button")
  public void userClicksSignInButton() {
    homePage.clickSignInButton();
  }

  @And("User checks that login field visible")
  public void userChecksThatLoginFieldVisible() {
    signInPage = pageFactoryManager.getSignInPage();
    signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getLoginField());
    signInPage.isLoginFieldVisible();
  }

  @And("User checks that continue button visible")
  public void userChecksThatContinueButtonVisible() {
    signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getContinueButton());
    signInPage.isContinueButtonVisible();
  }

  @And("User clicks continue button")
  public void userClicksContinueButton() {
    signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getContinueButton());
    signInPage.clickContinueButton();
  }

  @Then("User checks that alert message is visible")
  public void userChecksThatAlertMessageIsVisible() {
    signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    assertTrue(signInPage.isAlertMessageVisible());
  }


  @And("User checks language icon visible")
  public void userChecksLanguageIconVisible() {
    homePage.isLanguageIconVisible();
  }

  @And("User checks header visibility")
  public void userChecksHeaderVisibility() {
    homePage.isHeaderVisible();
  }

  @And("User clicks language icon")
  public void userClicksLanguageIcon() {
    homePage.clickLanguageIcon();

  }

  @And("User checks that languages for select visible")
  public void userChecksThatLanguagesForSelectVisible() {
    languagePage = pageFactoryManager.getLanguagePage();
    languagePage.waitVisibilityOfElement(DEFAULT_TIMEOUT,
        languagePage.getLanguagesForSelect().get(0));
    Assert.assertTrue(languagePage.isLanguagesForSelectVisible());
  }

  @When("User clicks on second language in the list")
  public void userClicksOnSecondLanguageInTheList() {
    languagePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    languagePage.clickSecondLanguage();
  }

  @And("User clicks on save changes language button")
  public void userClicksOnSaveChangesLanguageButton() {
    languagePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    languagePage.isSaveChangesButtonVisible();
    languagePage.clickSaveChangesButton();
  }

  @Then("User checks that current url contains {string} language")
  public void checkCurrentUrl(final String language) {
    assertTrue(driver.getCurrentUrl().contains(language));
  }


  @When("User enter {string} to email field")
  public void userEnterKeywordToEmailField(final String keyword) {
    signInPage.enterKeywordToLoginField(keyword);
  }

  @And("User checks continue button visible")
  public void userChecksContinueButtonVisible() {
    signInPage.isContinueButtonVisible();
  }

  @Then("User checks that error message visible")
  public void userChecksThatErrorMessageVisible() {
    signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getErrorMessage());
    assertTrue(signInPage.isErrorMessageVisible());
  }

  @And("User checks location icon visibility")
  public void userChecksLocationIconVisibility() {
    homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    homePage.isLocationIconVisible();
  }

  @And("User clicks location icon")
  public void userClicksLocationIcon() {
    homePage.clickLocationIcon();
  }

  @And("User checks location popup visibility")
  public void userChecksLocationPopupVisibility() {
    homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    homePage.isLocationPopUpVisible();
  }

  @And("User clicks location dropdown  menu")
  public void userClicksLocationDropdownMenu() {
    homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    homePage.clickDropdownCountryMenu();
  }

  @When("User clicks on first country")
  public void userClicksOnFirstCountry() {
    homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    homePage.clickCountryListOnFirstCountry();
  }

  @And("User clicks on submit button")
  public void userClicksOnSubmitButton() {
    homePage.clickSubmitCountryButton();
  }

  @Then("User checks that location icon contains {string} text")
  public void userChecksThatLocationIconContainsCountryNameText(final String countryName) {
    homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    assertEquals(homePage.locationIcon().getText(), countryName);
  }

  @When("User enter {string} to search field")
  public void userEnterProductNameToSearchField(final String productName) {
    homePage.enterProductNameToSearchField(productName);
  }

  @And("User clicks on search button")
  public void userClicksOnSearchButton() {
    homePage.clickSearchButton();
  }

  @And("User clicks on first product in search results list")
  public void userClicksOnFirstProductInSearchResultsList() {
    searchResultPage = pageFactoryManager.getSearchResultPage();
    searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,
        searchResultPage.getSearchResultList().get(0));
  }

  @And("User clicks Add to Cart button")
  public void userClicksButton() {
    productPage = pageFactoryManager.getProductPage();
    productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    productPage.clickAddToCartButton();
  }

  @Then("User checks that add to cart popup header is {string}")
  public void userChecksThatAddToCartPopupHeaderIsHeader(final String expectedText) {
    checkoutPage = pageFactoryManager.getCheckoutPage();
    checkoutPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    Assert.assertEquals(checkoutPage.getAddToCartPopupHeaderText(), expectedText);
  }

  @And("User checks that Go to Cart button visible")
  public void userChecksThatGoToCartButtonVisible() {
    Assert.assertTrue(checkoutPage.isGoToCartButtonVisible());
  }

  @And("User checks that Proceed to checkout button visible")
  public void userChecksThatProceedToCheckoutButtonVisible() {
    Assert.assertTrue(checkoutPage.isProceedToCheckoutButtonVisible());
  }

  @When("User open side menu")
  public void userOpenSideMenu() {
    homePage.clickSideMenuButton();
  }

  @Then("User check that amount of submenu  in side menu list are {int}")
  public void userCheckThatAmountOfSubmenuInSideMenuListAre(int arg0) {
    homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    Assert.assertEquals(homePage.getAmountOfSideMenuTitles(), arg0);
  }

  @And("User clicks create new account button")
  public void userClicksCreateNewAccountButton() {
    signInPage = pageFactoryManager.getSignInPage();
    signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    signInPage.clickCreateNewAccountButton();
  }

  @And("User checks name, email, password fields visibility")
  public void userChecksNameEmailPasswordFieldsVisibility() {
    registrationPage = pageFactoryManager.getRegistrationPage();
    registrationPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    registrationPage.isNameFieldVisible();
    registrationPage.isEmailAddressFieldVisible();
    registrationPage.isPasswordFieldVisible();
  }

  @And("User checks create account button visibility")
  public void userChecksCreateAccountButtonVisibility() {
    Assert.assertTrue(registrationPage.isCreateNewAccountOnAmazonButtonVisible());
  }

  @When("User enter {string} to name field")
  public void userEnterNameToNameField(final String name) {
    registrationPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    registrationPage.enterNameToNameField(name);
  }

  @And("User enter {string} to email_address  field")
  public void userEnterEmailToEmail_addressField(final String email) {
    registrationPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    registrationPage.enterEmailToEmailAddressField(email);
  }

  @And("User enter {string} to password field")
  public void userEnterPasswordToPasswordField(final String password) {
    registrationPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    registrationPage.enterPasswordToPasswordField(password);
  }

  @And("User re-enter {string} to password confirmation field")
  public void userReEnterPasswordToPasswordConfirmationField(final String password) {
    registrationPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    registrationPage.enterPasswordToPasswordConfirmationField(password);
  }

  @And("User clicks  create new account on Amazon button")
  public void userClicksCreateNewAccountOnAmazonButton() {
    registrationPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    registrationPage.clickCreateNewAccountOnAmazonButton();
  }

  @Then("User checks that warning message visible")
  public void userChecksThatWarningMessageVisible() {
    registrationPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registrationPage.getWarningMessage());
    Assert.assertTrue(registrationPage.isWarningMessageVisible());
  }
}
