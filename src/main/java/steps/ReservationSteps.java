package steps;

import org.openqa.selenium.WebDriver;
import page.ReservationsPage;
import utils.SeleniumUtils;

public class ReservationSteps extends SeleniumUtils {

  public ReservationSteps(WebDriver driver) {
    this.driver = driver;
  }

  ReservationsPage reservationPage = new ReservationsPage();

  public void reservaData() throws InterruptedException {
    reservationPage.reservaData();
  }

  public boolean geraReserva() {
    return reservationPage.geraReserva();
  }

  public boolean cancelarReserva() {
    return reservationPage.cancelaReserva();
  }

  public boolean validaReserva() throws InterruptedException {
    return reservationPage.validaReserva();
  }

  public void entrarFilaDeEspera() throws InterruptedException {
    reservationPage.entrarFilaDeEspera();
  }

  public void sairLayoutFilaEspera() throws InterruptedException {
    reservationPage.sairLayoutFilaEspera();
  }

  public boolean confirmaFila() throws InterruptedException {
    return reservationPage.confirmaFila();
  }

  public void sairFilaEspera() throws InterruptedException {
    reservationPage.sairFilaEspera();
  }


}
