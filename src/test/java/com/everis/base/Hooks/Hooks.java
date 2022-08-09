package com.everis.base.Hooks;

import com.everis.base.NetflixService;
import io.cucumber.java.BeforeStep;

public class Hooks {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(Hooks.class);

    //https://www.baeldung.com/java-cucumber-hooks
    @BeforeStep
    public void beforeStep(){ //
        LOGGER.info( "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }
}
