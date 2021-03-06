package manager;

import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LanguagePage;
import pages.ProductPage;
import pages.RegistrationPage;
import pages.SearchResultPage;
import pages.SignInPage;

public class PageFactoryManager {

  WebDriver driver;

  public PageFactoryManager(WebDriver driver) {
    this.driver = driver;
  }

  public HomePage getHomePage() {
    return new HomePage(driver);
  }

  public ProductPage getProductPage() {
    return new ProductPage(driver);
  }

  public SignInPage getSignInPage() {
    return new SignInPage(driver);
  }

  public LanguagePage getLanguagePage() {
    return new LanguagePage(driver);
  }

  public RegistrationPage getRegistrationPage() {
    return new RegistrationPage(driver);
  }

  public SearchResultPage getSearchResultPage() {
    return new SearchResultPage(driver);
  }

  public CheckoutPage getCheckoutPage() {
    return new CheckoutPage(driver);
  }

}
