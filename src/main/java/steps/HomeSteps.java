package steps;

import org.openqa.selenium.WebDriver;
import page.HomePage;
import utils.SeleniumUtils;

public class HomeSteps extends SeleniumUtils {

  public HomeSteps(WebDriver driver){
    this.driver = driver;
  }

  HomePage homePage = new HomePage();

  public void acessoReservas() throws InterruptedException {
    homePage.acessoReservas();
  }

}
