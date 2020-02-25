import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.FacilitiesSteps;
import steps.HomeSteps;
import steps.LoginSteps;
import steps.ReservationSteps;

public class TestesCondominioApplicationTest {

  private static final Logger logger = Logger.getLogger(TestesCondominioApplicationTest.class);
  WebDriver driver = new ChromeDriver();
  String cliente1 = "yuri.tolla.ps1@townsq.com.br";
  String cliente2 = "yuri.tolla.ps2@townsq.com.br";
  String senha = "yuri123";
  String tenis = "tenis";
  String gourmet = "gourmet";
  String festas = "festas";
  LoginSteps loginSteps = new LoginSteps(driver);
  HomeSteps homeSteps = new HomeSteps(driver);
  FacilitiesSteps facilitiesSteps = new FacilitiesSteps(driver);
  ReservationSteps reservationSteps = new ReservationSteps(driver);

  @Test
  public void deveGerarNovaReserva() {
    try {
      loginSteps.acessoTelaLogin();
      logger.debug("\n Tela de Login Acessada");
      loginSteps.realizaLogin(cliente1, senha);
      logger.debug("\n Login realizado");

      homeSteps.acessoReservas();
      logger.debug("\n Reservas acessadas");

      facilitiesSteps.acessoDependencia(tenis);
      logger.debug("\n Dependencias acessadas");

      reservationSteps.reservaData();
      logger.debug("\n Data selecionada");

      assertTrue(reservationSteps.geraReserva());
      logger.debug("\n Reserva gerada com sucesso");

      reservationSteps.cancelarReserva();
      logger.debug("\n Reserva cancelada");
      driver.close();
      logger.debug("\n Fim do log \n");

    } catch (Exception ex) {
      logger.debug("\n Erro ao gerar nova reserva.", ex);
    }

  }

  @Test
  public void deveTestarConflitoDeReserva() {
    try {
      loginSteps.acessoTelaLogin();
      logger.debug("\n Tela de Login Acessada");

      loginSteps.realizaLogin(cliente1, senha);
      logger.debug("\n Login realizado");

      homeSteps.acessoReservas();
      logger.debug("\n Reservas acessadas");

      facilitiesSteps.acessoDependencia(tenis);
      logger.debug("\n Dependencias acessadas");

      reservationSteps.reservaData();
      logger.debug("\n Data selecionada");

      assertTrue(reservationSteps.geraReserva());
      logger.debug("\n Reserva gerada");

      loginSteps.deslogar(cliente1);
      logger.debug("\n Conta deslogada");

      loginSteps.realizaLogin(cliente2, senha);
      logger.debug("\n Login realizado");

      homeSteps.acessoReservas();
      logger.debug("\n Reservas acessadas");

      facilitiesSteps.acessoDependencia(tenis);
      logger.debug("\n Dependencias acessadas");

      reservationSteps.reservaData();
      logger.debug("\n Data selecionada");

      assertTrue(reservationSteps.validaReserva());
      logger.debug("\n Conflito evitado com sucesso");

      loginSteps.deslogar(cliente2);
      logger.debug("\n Conta deslogada");

      loginSteps.realizaLogin(cliente1, senha);
      logger.debug("\n Login realizado");

      homeSteps.acessoReservas();
      logger.debug("\n Reservas acessadas");

      facilitiesSteps.acessoDependencia(tenis);
      logger.debug("\n Dependencias acessadas ");

      reservationSteps.reservaData();
      logger.debug("\n Data selecionada");

      reservationSteps.cancelarReserva();
      logger.debug("\n Reserva cancelada com sucesso.");

      driver.close();
      logger.debug("\n Fim do log \n");

    } catch (Exception ex) {
      logger.debug("\n Erro ao gerar conflito de reservas", ex);
    }
  }

  @Test
  public void deveTestarFilaEspera() {
    try {
      loginSteps.acessoTelaLogin();
      logger.debug("\n Tela de Login Acessada");

      loginSteps.realizaLogin(cliente1, senha);
      logger.debug("\n Login realizado para o cliente " + cliente1);

      homeSteps.acessoReservas();
      logger.debug("\n Reservas acessadas");

      facilitiesSteps.acessoDependencia(tenis);
      logger.debug("\n Dependencia " + tenis + " acessada");

      reservationSteps.reservaData();
      logger.debug("\n Data selecionada");

      assertTrue(reservationSteps.geraReserva());
      logger.debug("\n Reserva gerada");

      loginSteps.deslogar(cliente1);
      logger.debug("\n Conta deslogada");

      loginSteps.realizaLogin(cliente2, senha);
      logger.debug("\n Login realizado para o cliente " + cliente2);

      homeSteps.acessoReservas();
      logger.debug("\n Reservas acessadas");

      facilitiesSteps.acessoDependencia(tenis);
      logger.debug("\n Dependencia " + tenis + " acessada");

      reservationSteps.reservaData();
      logger.debug("\n Data selecionada");

      reservationSteps.entrarFilaDeEspera();
      logger.debug("\n Usuario cadastrado na fila de espera");

      reservationSteps.sairLayoutFilaEspera();
      logger.debug("\n Layout de espera fechado");

      assertTrue(reservationSteps.confirmaFila());
      logger.debug("\n Confirmada fila de espera");

      reservationSteps.entrarFilaDeEspera();
      logger.debug("\n Acessando Fila de espera");

      reservationSteps.sairFilaEspera();
      logger.debug("\n Saída da fila executada");

      reservationSteps.sairLayoutFilaEspera();
      logger.debug("\n Layout de espera fechado");

      loginSteps.deslogar(cliente2);
      logger.debug("\n Conta deslogada");

      loginSteps.realizaLogin(cliente1, senha);
      logger.debug("\n Login realizado");

      homeSteps.acessoReservas();
      logger.debug("\n Reservas acessadas");

      facilitiesSteps.acessoDependencia(tenis);
      logger.debug("\n Dependencias acessadas");

      reservationSteps.reservaData();
      logger.debug("\n Data selecionada");

      reservationSteps.cancelarReserva();
      logger.debug("\n Reserva cancelada com sucesso.");

      driver.close();
      logger.debug("\n Fim do log \n");


    } catch (Exception ex) {
      logger.debug("\n Erro ao gerar fila de espera", ex);
    }
  }

  @Test
  public void deveConfirmarReservaDaFilaDeEspera() {
    try {
      loginSteps.acessoTelaLogin();
      logger.debug("\n Tela de Login Acessada");

      loginSteps.realizaLogin(cliente1, senha);
      logger.debug("\n Login realizado para o cliente " + cliente1);

      homeSteps.acessoReservas();
      logger.debug("\n Reservas acessadas");

      facilitiesSteps.acessoDependencia(tenis);
      logger.debug("\n Dependencia " + tenis + " acessada");

      reservationSteps.reservaData();
      logger.debug("\n Data selecionada");

      assertTrue(reservationSteps.geraReserva());
      logger.debug("\n Reserva gerada");

      loginSteps.deslogar(cliente1);
      logger.debug("\n Conta deslogada");

      loginSteps.realizaLogin(cliente2, senha);
      logger.debug("\n Login realizado para o cliente " + cliente2);

      homeSteps.acessoReservas();
      logger.debug("\n Reservas acessadas");

      facilitiesSteps.acessoDependencia(tenis);
      logger.debug("\n Dependencia " + tenis + " acessada");

      reservationSteps.reservaData();
      logger.debug("\n Data selecionada");

      reservationSteps.entrarFilaDeEspera();
      logger.debug("\n Usuario cadastrado na fila de espera");

      reservationSteps.sairLayoutFilaEspera();
      logger.debug("\n Layout de espera fechado");

      assertTrue(reservationSteps.confirmaFila());
      logger.debug("\n Confirmada fila de espera");

      loginSteps.deslogar(cliente2);
      logger.debug("\n Conta deslogada");

      loginSteps.realizaLogin(cliente1, senha);
      logger.debug("\n Login realizado");

      homeSteps.acessoReservas();
      logger.debug("\n Reservas acessadas");

      facilitiesSteps.acessoDependencia(tenis);
      logger.debug("\n Dependencias acessadas");

      reservationSteps.reservaData();
      logger.debug("\n Data selecionada  ");

      reservationSteps.cancelarReserva();
      logger.debug("\n Reserva cancelada com sucesso");

      loginSteps.deslogar2();
      logger.debug("\n Conta deslogada");

      loginSteps.realizaLogin(cliente2, senha);
      logger.debug("\n Login realizado");

      homeSteps.acessoReservas();
      logger.debug("\n Reservas acessadas");

      facilitiesSteps.acessoDependencia(tenis);
      logger.debug("\n Dependencia " + tenis + " acessada");

      reservationSteps.reservaData();
      logger.debug("\n Data selecionada");

      assertTrue(reservationSteps.geraReserva());
      logger.debug("\n Reserva pela fila de espera gerada com sucesso");


      reservationSteps.cancelarReserva();
      logger.debug("\n Reserva cancelada");

      driver.close();
      logger.debug("\n Fim do log \n");

    } catch (Exception ex) {
      logger.debug("\n Erro ao gerar fila de espera", ex);
    }
  }
}
