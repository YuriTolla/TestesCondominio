package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtils;

public class FacilitiesPage extends SeleniumUtils {

  public void acessoDependencia(String dependencia) throws InterruptedException {
    wait(6);
    if (dependencia.equals("gourmet")) {
      System.out.println("Acessando espaco Gourmet");
      WebElement espacoGourmet = driver
          .findElement(By.cssSelector(
              "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > main-facilities > sc-list > div > div > div > div:nth-child(4) > div > facilities-list > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(1) > div > div > div"));
      espacoGourmet.click();
    } else if (dependencia.equals("tenis")) {
      System.out.println("Acessando espaco quadra de Tenis");
      WebElement quadraTenis = driver
          .findElement(By.cssSelector(
              "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > main-facilities > sc-list > div > div > div > div:nth-child(4) > div > facilities-list > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > div > div > div"));
      quadraTenis.click();
    } else if (dependencia.equals("festas")) {
      System.out.println("Acessando espaco salão de Festas");
      WebElement salaoFestas = driver
          .findElement(By.cssSelector(
              "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > main-facilities > sc-list > div > div > div > div:nth-child(4) > div > facilities-list > div > div > div > table > tbody > tr:nth-child(3) > td:nth-child(1) > div > div > div"));
      salaoFestas.click();
    } else {
      System.out.println("Não foi localizado objeto desejado");
    }
  }
}
