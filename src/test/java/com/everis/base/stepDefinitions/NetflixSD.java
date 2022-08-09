package com.everis.base.stepDefinitions;

import com.everis.base.NetflixService;
//import com.everis.base.steps.NetflixSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * @author jovallep
 */
public class NetflixSD {

    @Steps
    public NetflixService netflix;


    @Given("que la aplicación esta operativa")
    public void queLaAplicacionEstaOperativa() {

    }

    @When("obtiene la lista: {int} de clientes suscritos")
    public void obtieneLaListaDeClientesSuscritos(int i) {

        netflix.listUser(i);
    }

    @When("obtiene al cliente: {int} suscrito")
    public void obtieneAlClienteSuscrito(int user) {

        netflix.getUser(user);
    }

    @Then("valida que la respuesta es {int}")
    public void buscaAlCliente(int i) {
        netflix.validateStatusCode(i);
    }


    @Then("valida que el correo es {string}")
    public void validaQueElCorreoEs(String var) {
        netflix.validateBodyContent(var);

    }

    @When("obtiene la lista: {int} de clientes suscritos como objeto")
    public void obtieneLaListaDeClientesSuscritosComoObjeto(int i) {
        netflix.listUserObject(i);

    }

    @Then("valida que el apellido es {string}")
    public void validaQueElApellidoEsString(String apellido) {
        netflix.validarApellido(apellido);
    }

    @Then("valida que el nombre es {string}")
    public void validaQueElNombreEs(String nombre) {

        netflix.validarNombre(nombre);
    }

    @When("inserto los valores del cliente con nombre {string} y trabajo {string}")
    public void insertoLosValoresDelClienteConNombreYTrabajo(String nombre, String trabajo) {
        netflix.insertUsuario(nombre, trabajo);
    }


    @And("valida que el trabajo es {string}")
    public void validaQueElTrabajoEs(String trabajo) {

        netflix.validaTrabajo(trabajo);
    }


    @When("^ejecuta la creacion \"([^\"]*)\"$")
    public void ejecutaLaCreacion(String api) {
        netflix.sendPostRequest(api);
    }


    @And("^agrega la cabecera key: \"([^\"]*)\", y valor: \"([^\"]*)\"$")
    public void agregaLaCabeceraKeyYValor(String k, String v) {
        netflix.setHeader(k, v);
    }


    @And("valida el {string} sea {string}")
    public void validaElSea(String arg0, String arg1) {
        netflix.checkDataResponse(arg0,arg1);
    }

    @And("inicializo request en post")
    public void agregoParametrosDeRequestEnPost() {
        netflix.inicializoParametrosRequestPost();
    }
}
