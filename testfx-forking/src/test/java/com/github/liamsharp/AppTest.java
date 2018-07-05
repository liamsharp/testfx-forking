package com.github.liamsharp;

import java.util.concurrent.TimeoutException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.testfx.api.FxToolkit;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppTest
{
    private static final Logger LOGGER = LogManager.getLogger(AppTest.class);

    @Test
    public void testFxTest() throws TimeoutException, InterruptedException
    {
        LOGGER.info("AppTest started");
        final Stage stage = FxToolkit.registerPrimaryStage();
        final Application app = FxToolkit.setupApplication(App.class);
        LOGGER.info("app: " + app + ", stage: " + stage);
        logApp(app);
        FxToolkit.cleanupApplication(app);
        LOGGER.info("App cleaned up");
    }
    
    private void logApp(
        final Application app)
    {
        LOGGER.info("app: " + app);
    }

}
