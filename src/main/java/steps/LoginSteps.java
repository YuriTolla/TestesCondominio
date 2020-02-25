package steps;

import org.openqa.selenium.WebDriver;
import page.LoginPage;
import utils.SeleniumUtils;

public class LoginSteps extends SeleniumUtils {

  public LoginSteps(WebDriver driver){
    this.driver = driver;
}

  LoginPage loginPage = new LoginPage();

  public void acessoTelaLogin(){
    loginPage.acessoLoginPortal();
  }

  public void realizaLogin(String email, String senha) {
    loginPage.realizaLogin(email, senha);
  }

  public void deslogar(String cliente) throws InterruptedException {
    loginPage.deslogar(cliente);
  }

  public void deslogar2() throws InterruptedException {
    loginPage.deslogar2();
  }
}
