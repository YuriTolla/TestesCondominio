package steps;

import org.openqa.selenium.WebDriver;
import page.FacilitiesPage;
import utils.SeleniumUtils;

public class FacilitiesSteps extends SeleniumUtils {

    public FacilitiesSteps(WebDriver driver){
      this.driver = driver;
    }

    FacilitiesPage facilitiesPage = new FacilitiesPage();

    public void acessoDependencia(String dependencia) throws InterruptedException {
      facilitiesPage.acessoDependencia(dependencia);
    }

}
