import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepsJuegos {
    public juegosServicio servicio;
    static private final String BASE_URL = "https://www.freetogame.com/api/games";
    @Given("valido que el servicio responde {int}")
    public void validoQueElServicioResponde(int arg0) {
        servicio.validateStatusCode(200);
    }

    @When("entro a la pagina")
    public void entroALaPagina() {
    }

    @Then("Accedo a la lista de juegos")
    public void accedoALaListaDeJuegos() {
        servicio.validateBodyContent("tytle");
    }

    @Given("que tengo una consulta fallida")
    public void queTengoUnaConsultaFallida() {
    }

    @When("se ingresa un id")
    public void seIngresaUnId() {
       servicio.gettytle(500);
    }

    @Then("muestra un codigo de error {int}")
    public void muestraUnCodigoDeError(int arg0) {
        servicio.validateStatusCode(404);
    }
}
