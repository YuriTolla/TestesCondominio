package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtils;

public class LoginPage extends SeleniumUtils {

  WebElement campoDeslogar;

  public void acessoLoginPortal() {
    System.out.println("acessando site da townSQ...");
    driver.get("https://qa.townsq.io/login");
  }


  public void realizaLogin(String cliente, String senha) {
    System.out.println("inserindo campo email");
    WebElement campoLogin = driver.findElement(By.name("email"));
    campoLogin.sendKeys(cliente);
    System.out.println("inserindo campo de senha");
    WebElement campoSenha = driver.findElement(By.name("password"));
    campoSenha.sendKeys((senha));

    WebElement button = driver.findElement(By.id("login--button--submit"));
    button.click();
  }

  public void deslogar(String cliente) throws InterruptedException {
    System.out.println("deslogando...");
    wait(2);
    WebElement campoPerfil = driver.findElement(
        (By.cssSelector
            ("#tsq-navbar > div.dynamic-content-wrapper > tsq-profile-dropdown")));
    campoPerfil.click();
    wait(2);
    if (cliente.equals("yuri.tolla.ps1@townsq.com.br")) {
      campoDeslogar = driver.findElement
          (By.cssSelector
              ("#tsq-navbar > div.dynamic-content-wrapper > tsq-profile-dropdown > div.tsq-profile-dropdown-open.ng-tns-c18-4.ng-trigger.ng-trigger-dumbParent.ng-star-inserted > div > div.tsq-dropdown-content > ul > li:nth-child(3)"));
    } else if (cliente.equals("yuri.tolla.ps2@townsq.com.br")) {
      campoDeslogar = driver.findElement
          (By.cssSelector(
              "#tsq-navbar > div.dynamic-content-wrapper > tsq-profile-dropdown > div.tsq-profile-dropdown-open.ng-tns-c18-25.ng-trigger.ng-trigger-dumbParent.ng-star-inserted > div > div.tsq-dropdown-content > ul > li:nth-child(3)"));

    } else {
      System.out.println("Não foi possível localizar botão sair");
    }
 
    campoDeslogar.click();
    wait(2);

  }

  public void deslogar2() throws InterruptedException {
    System.out.println("deslogando...");
    wait(2);
    WebElement campoPerfil = driver.findElement(
        (By.cssSelector
            ("#tsq-navbar > div.dynamic-content-wrapper > tsq-profile-dropdown")));
    campoPerfil.click();
    wait(2);
    campoDeslogar = driver.findElement(By.cssSelector(
        "#tsq-navbar > div.dynamic-content-wrapper > tsq-profile-dropdown > div.tsq-profile-dropdown-open.ng-tns-c18-45.ng-trigger.ng-trigger-dumbParent.ng-star-inserted > div > div.tsq-dropdown-content > ul > li:nth-child(3) > a"));
    campoDeslogar.click();
    wait(2);
  }
}
