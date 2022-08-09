package com.everis.base;

import io.cucumber.core.gherkin.Step;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.apache.xml.security.stax.ext.DocumentContext;
import org.eclipse.jetty.io.WriterOutputStream;
import org.hamcrest.MatcherAssert;
import org.json.JSONObject;
import org.seleniumhq.jetty9.http.HttpStatus;

import java.io.PrintStream;
import java.io.StringWriter;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import io.cucumber.java.*;
import io.cucumber.core.gherkin.Step;

public class ServicioCore {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ServicioCore.class);

    static private String BASE_URL = null;
    static private String URL = null;
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    private RequestSpecification requestSpecification;
    private static String sRequest,sResponse;
    private static StringWriter requestWriter,responseWriter;
    private static PrintStream requestCapture,responseCapture;
    private Response response = null;
    private String sResponseBody = null;
    private int icodigoResponse = 0;


    @Before
    public void init() {
        LOGGER.info("i init");
            RestAssured.useRelaxedHTTPSValidation();
        LOGGER.info("f init");
    }


    public void consultarServicioDisponibilidad(String url){

        LOGGER.info("i consultarServicioDisponibilidad");
        response = null;

        url = analizaURL(url);
        //jsonBody = analizaJsonBody(jsonBody);

        URL = concatenarURL(url,null);
        LOGGER.info("URL modificada: "+ URL);

        //Se inicializa la URL base
        requestSpec = new RequestSpecBuilder().setBaseUri(URL).build();

        resetRequestResponseCapture();

        RequestSpecification reqGiven = given();

        reqGiven.spec(requestSpec);
        reqGiven.contentType(ContentType.JSON);
        response = reqGiven
                .log().all()
                .filter(new RequestLoggingFilter(requestCapture))
                .filter(new ResponseLoggingFilter(responseCapture))
                //.pathParams("variable", "valoe"")
                //.queryParam("variable", "value")
                //.body(jsonBody.toString())
                .when()
                .get();
        response.toString();
        LOGGER.info("Response StatusCode: " + response.getStatusCode());
        LOGGER.info("Response Body: " + response.getBody().asString());

        sRequest=requestWriter.toString();
        sResponse=responseWriter.toString();

        LOGGER.info("sRequest Completo: ");
        LOGGER.info(sRequest);
        LOGGER.info("sResponse Completo: ");
        LOGGER.info(sResponse);
        LOGGER.info("f consultarServicioDisponibilidad");
    }
    public void consultarServicioGet(String url, String path){

        LOGGER.info("i consultarServicioPostGet");
        response = null;

        url = analizaURL(url);
        //jsonBody = analizaJsonBody(jsonBody);

        URL = concatenarURL(url,path);
        LOGGER.info("concatenarURL: "+ URL);

        //Se inicializa la URL base
        requestSpec = new RequestSpecBuilder().setBaseUri(URL).build();

        resetRequestResponseCapture();

        RequestSpecification reqGiven = given();

        reqGiven.spec(requestSpec);
        reqGiven.contentType(ContentType.JSON);
        response = reqGiven
                .log().all()
                .filter(new RequestLoggingFilter(requestCapture))
                .filter(new ResponseLoggingFilter(responseCapture))
                //.pathParams("variable", "valoe"")
                .queryParam("CUSTOMER_ID", "68195")
                .queryParam("PASSWORD", "1234!")
                .queryParam("Account_No", "1")
                //.body(jsonBody.toString())
                .when()
                .get();
        response.toString();
        LOGGER.info("Response StatusCode: " + response.getStatusCode());
        LOGGER.info("Response Body: " + response.getBody().asString());//¿PUEDO PONER UN JSON?

        sRequest=requestWriter.toString();
        sResponse=responseWriter.toString();

        LOGGER.info("sRequest Completo: ");
        LOGGER.info(sRequest);
        LOGGER.info("sResponse Completo: ");
        LOGGER.info(sResponse);
        LOGGER.info("f consultarServicioGet");
    }
    public void consultarServicioPost(String url, String path, String jsonBody){

        LOGGER.info("i consultarServicioPost");
        response = null;

        url = analizaURL(url);
        jsonBody = analizaJsonBody(jsonBody);

        URL = concatenarURL(url,path);
        LOGGER.info("concatenarURL: "+ URL);

        //Se inicializa la URL base
        requestSpec = new RequestSpecBuilder().setBaseUri(URL).build();

        resetRequestResponseCapture();

        RequestSpecification reqGiven = given();

        reqGiven.spec(requestSpec);
        reqGiven.contentType(ContentType.JSON);
        response = reqGiven
                .log().all()
                .filter(new RequestLoggingFilter(requestCapture))
                .filter(new ResponseLoggingFilter(responseCapture))
                //.pathParams("variable", "valoe"")
                //.queryParam("variable", "value")
                .body(jsonBody.toString())
                .when()
                .get();
        response.toString();
        LOGGER.info("Response StatusCode: " + response.getStatusCode());
        LOGGER.info("Response Body: " + response.getBody().asString());

        sRequest=requestWriter.toString();
        sResponse=responseWriter.toString();

        LOGGER.info("sRequest Completo: ");
        LOGGER.info(sRequest);
        LOGGER.info("sResponse Completo: ");
        LOGGER.info(sResponse);
        LOGGER.info("f consultarServicioPost");
    }

    public void validarCodigoEsperado(int codigoRespuestaEsperado){
        LOGGER.info("codigoRespuestaEsperado: " + codigoRespuestaEsperado);
        LOGGER.info("response.getStatusCode(): " + response.getStatusCode());
        assertThat( response.getStatusCode(), is(codigoRespuestaEsperado));
    }
    public void validaRespuesta(){

        MatcherAssert.assertThat(response.getBody().path("message.ErrorMsg:"), equalTo("Success"));
        //MatcherAssert.assertThat(response.asString().contains("Success"), equalTo("Success"));
        //Assert.assertEquals(bodyAsString.contains("Hyderabad") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");

    }
    public void configurarURLBaseServicio(String uri){
        LOGGER.info("i configurarURLBaseServicio");
        BASE_URL = uri;
        LOGGER.info("f configurarURLBaseServicio");
    }

/*
#######################################################################
    Métodos de Apoyo para realizar tareas comunes
#######################################################################
 */
    private String analizaURL(String url){
        //Si la url es null, toma el valor de BASE_URL
        if(url == null){
            url = BASE_URL;
        }
        return url;
    }
    private String analizaJsonBody(String jsonBody){
        //Si el JsonBody es Null, le asigna vacio. Para evitar NullPointerException
        if(jsonBody== null){
            jsonBody = "";
        }
        return jsonBody;
    }

    private String concatenarURL(String url1, String url2){
        //Solo se encarga de unir correctamente dos partes de la URL
        //c1: http://google.com       /Ruta   => http://google.com/Ruta
        //c2: http://google.com/       /Ruta  => http://google.com/Ruta
        //c3: http://google.com/       Ruta   => http://google.com/Ruta
        //c4: http://google.com       Ruta    => http://google.com/Ruta
        LOGGER.info("CONCATENAR: " + url1 + " y " + url2);
        String url="";
        if(url1 == null){url1 = "";}
        if(url2 == null){url2 = "";}
        if(url1.length()>0){
            //c1: http://google.com       /Ruta
            if(url2.length()>0) {
                if (!url1.substring(url1.length() - 1).equals("/") && url2.substring(0, 1).equals("/")) {
                    url = url1 + url2;
                }
                //c3: http://google.com/       Ruta
                if (url1.substring(url1.length() - 1).equals("/") && !url2.substring(0, 1).equals("/")) {
                    url = url1 + url2;
                }

                //c2: http://google.com/       /Ruta
                if (url1.substring(url1.length() - 1).equals("/") && url2.substring(0, 1).equals("/")) {
                    url = url1 + url2.substring(1);
                }

                //c4: http://google.com       Ruta
                if (!url1.substring(url1.length() - 1).equals("/") && !url2.substring(0, 1).equals("/")) {
                    url = url1 + "/" + url2;
                }
            }else{
                url = url1;
            }


        }else{
            url = url2;
        }
        return url;
    }
    private void resetRequestResponseCapture(){
        //Este codigo ayudará a interceptar los Requests / Response. Los inicializamos debidamente
        requestWriter =new StringWriter();
        requestCapture =new PrintStream(new WriterOutputStream(requestWriter),true);
        responseWriter =new StringWriter();
        responseCapture =new PrintStream(new WriterOutputStream(responseWriter),true);
    }

}
