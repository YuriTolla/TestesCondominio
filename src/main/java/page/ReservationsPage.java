package page;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SeleniumUtils;

public class ReservationsPage extends SeleniumUtils {

  public void reservaData() throws InterruptedException {
    wait(6);
    System.out.println("selecionando data 28 de fevereiro");
    WebElement data = driver
        .findElement(By.cssSelector(
            "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > root-reservations > main-reservations > facilty-reservations > div > div > div.panel-body > sc-calendar > div > div:nth-child(7) > sc-calendar-day:nth-child(6) > div > div:nth-child(1) > div"));
    data.click();
    wait(2);
  }

  public boolean geraReserva() {
    try {
      System.out.println("selecionando horario 9:00 - 10:00");
      WebElement horario = driver.findElement(By.cssSelector(
          "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > root-reservations > main-reservations > facilty-reservations > div > div > div.panel-body > day-timeslots > div > div:nth-child(2) > div.row.row-margin > div.col-md-5.col-sm-12.col-xs-12 > div > button"));
      horario.click();
      wait(2);
      System.out.println("inserindo descricao (Teste Yuri Tolla)");
      WebElement descricao = driver.findElement(By.name("description"));
      descricao.sendKeys("Teste Yuri Tolla");
      System.out.println("Confirmando reserva");
      WebElement reserva = driver.findElement(By.id("confirm-button"));
      reserva.click();
      System.out.println("reserva foi gerada");
      return true;
    } catch (Exception x) {
      System.out.println("nao foi possivel gerar uma reserva");
      return false;
    }
  }

  public boolean validaReserva() throws InterruptedException {
    wait(3);
    WebElement botaoHorario = driver.findElement(By.cssSelector(
        "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > root-reservations > main-reservations > facilty-reservations > div > div > div.panel-body > day-timeslots > div > div:nth-child(2) > div.row.row-margin > div.col-md-5.col-sm-12.col-xs-12 > div > button"));
    System.out.println("Validando se horario esta reservado");
    botaoHorario.click();
    WebElement reservado = driver.findElement
        (By.cssSelector(
            "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > root-reservations > main-reservations > facilty-reservations > div > div > div.panel-body > day-timeslots > div > div:nth-child(2) > div.row.row-margin > div.col-md-7.col-sm-12.col-xs-12.availability > div.row.availability-text > div"));
    return reservado.getText().equals("Reservado");
  }

  public boolean cancelaReserva() {
    try {
      wait(2);
      System.out.println("selecionando horario 9:00 - 10:00");
      WebElement horario = driver.findElement(By.cssSelector(
          "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > root-reservations > main-reservations > facilty-reservations > div > div > div.panel-body > day-timeslots > div > div:nth-child(2) > div.row.row-margin > div.col-md-5.col-sm-12.col-xs-12 > div > button"));
      horario.click();
      wait(2);
      WebElement reserva = driver.findElement(By.cssSelector(
          "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > root-reservations > main-reservations > facilty-reservations > event-form-modal > tsq-modal > div > div > div > div.modal-footer.ng-star-inserted > div > button:nth-child(2)"));
      reserva.click();
      wait(4);
      WebElement confirmaRemover = driver.findElement(By.xpath("//*[@id=\"dialog-confirm\"]"));
      confirmaRemover.click();
      wait(6);
      System.out.println("reserva cancelada");
      return true;
    } catch (Exception x) {
      System.out.println("nao foi possivel cancelar a reserva");
      return false;
    }
  }

  public void entrarFilaDeEspera() throws InterruptedException {
    wait(2);
    System.out.println("selecionando fila de espera");
    WebElement filaEspera = driver.findElement((By.cssSelector(
        "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > root-reservations > main-reservations > facilty-reservations > div > div > div.panel-body > day-timeslots > div > div:nth-child(2) > div.row.row-margin > div.col-md-7.col-sm-12.col-xs-12.availability > div.row.availability-button > button"
    )));
    filaEspera.click();

    wait(3);
    WebElement entrarFilaEspera = driver.findElement((By.cssSelector(
        "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > root-reservations > main-reservations > facilty-reservations > div > div > div.panel-body > day-timeslots > event-waiting-queue-modal > tsq-modal > div > div > div > div.modal-footer.ng-star-inserted > div > button.btn.btn-primary"
    )));
    entrarFilaEspera.click();
    System.out.println("fila de espera gerada");
  }

  public void sairLayoutFilaEspera() throws InterruptedException {
    wait(3);
    WebElement sairLayoutFilaEspera = driver.findElement(By.cssSelector(
        "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > root-reservations > main-reservations > facilty-reservations > div > div > div.panel-body > day-timeslots > event-waiting-queue-modal > tsq-modal > div > div > div > div.modal-header > img"
    ));
    sairLayoutFilaEspera.click();
  }

  public boolean confirmaFila() throws InterruptedException {
    wait(3);
    WebElement confirmaFila = driver.findElement(By.cssSelector(
        "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > root-reservations > main-reservations > facilty-reservations > div > div > div.panel-body > day-timeslots > div > div:nth-child(2) > div.row.row-margin > div.col-md-7.col-sm-12.col-xs-12.availability > div.row.availability-text > div"
    ));
    String fila = confirmaFila.getText();

    System.out.println("fila de espera confirmada com sucesso");
    return fila.equals("Seu nome está na fila de espera");
  }

  public void sairFilaEspera() throws InterruptedException {
    System.out.println("saindo da fila de espera");
    wait(3);
    WebElement sairFilaEspera = driver.findElement(By.cssSelector(
        "body > app-root > sc-workspace > div > div > div.flex-content-wrapper > div > root-reservations > main-reservations > facilty-reservations > div > div > div.panel-body > day-timeslots > event-waiting-queue-modal > tsq-modal > div > div > div > div.modal-body.tsq-scroll-y > div > div > div > div > a"
        )
    );
    sairFilaEspera.click();
  }


}
