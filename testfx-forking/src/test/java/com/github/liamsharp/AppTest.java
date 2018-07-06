package com.github.liamsharp;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import javafx.application.Application;

public class AppTest
{
    private static final Logger LOGGER = LogManager.getLogger(AppTest.class);

    @Test
    public void testStuff()
    {
        assertEquals(1, App.returnOne());
        
        final Application app = null;
        LOGGER.info("app: " + app);
//        logApp(app);
    }
    
//    private void logApp(
//        final Application app)
//    {
//        LOGGER.info("app: " + app);
//    }

}
