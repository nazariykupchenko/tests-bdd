package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

  @FindBy(css = "a.a-link-normal.s-link-style.a-text-normal")
  private List<WebElement> searchResultList;

  public SearchResultPage(WebDriver driver) {
    super(driver);
  }

  public List<WebElement> getSearchResultList() {
    return searchResultList;
  }
}
