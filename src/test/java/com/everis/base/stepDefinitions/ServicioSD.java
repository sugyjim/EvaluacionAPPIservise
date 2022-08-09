package com.everis.base.stepDefinitions;

import com.everis.base.ServicioCore;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;


public class ServicioSD {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ServicioSD.class);

    @Steps
    private ServicioCore servicioCore;


    @Then("el codigo de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int codigoRespuestaEsperado) {
        LOGGER.info("i elCodigoDeRespuestaEs");
        servicioCore.validarCodigoEsperado(codigoRespuestaEsperado);
        LOGGER.info("f elCodigoDeRespuestaEs");
    }


    @Given("la URL_BASE del Servicio es {string}")
    public void laURL_BASEDelServicioEs(String urlBase) {
        LOGGER.info("i laURL_BASEDelServicioEs");
        LOGGER.info("URL BASE = " + urlBase);
            servicioCore.configurarURLBaseServicio(urlBase);
        LOGGER.info("f laURL_BASEDelServicioEs");
    }



    @Given("la URL_BASE del Servicio responde {int}")
    public void laURL_BASEDelServicioResponde(int codigoRespuestaEsperado) {
        LOGGER.info("i laURL_BASEDelServicioResponde");
        LOGGER.info("Consulta la Disponibilidad del Servicio ... ");
        servicioCore.consultarServicioDisponibilidad(null);
        servicioCore.validarCodigoEsperado(codigoRespuestaEsperado);
        LOGGER.info("f laURL_BASEDelServicioResponde");
    }

    @When("consulto el Servicio con el Path {string}")
    public void consultoElServicioConElPath(String path) {
        LOGGER.info("i consultoElServicioConElPath");
        servicioCore.consultarServicioGet(null, path);
        LOGGER.info("f consultoElServicioConElPath");
    }

    @And("valido el resultado")
    public void validoElResultado() {
        servicioCore.validaRespuesta();
    }
}
