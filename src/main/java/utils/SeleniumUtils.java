package utils;

import static java.lang.Thread.sleep;

import org.openqa.selenium.WebDriver;


public class SeleniumUtils {

  public static WebDriver driver;


  public void wait(int tempo) throws InterruptedException {
    tempo = tempo * 1000;
    sleep(tempo);
  }

}
