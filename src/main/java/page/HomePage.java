package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtils;

public class HomePage extends SeleniumUtils {

  public void acessoReservas() throws InterruptedException {
    wait(12);
    System.out.println("Acessando modulo Reservas");
    WebElement campoReservas = driver
        .findElement(By.cssSelector("#menu-reservations > tsq-menu-group > div > div > span"));
    campoReservas.click();
System.out.println("Acessando sub modulo dependencias");
    WebElement campoDependencias = driver.findElement(By.cssSelector("#menu-amenities"));
    wait(2);
    campoDependencias.click();
  }

}
