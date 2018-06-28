package com.github.liamsharp;

import java.lang.management.ManagementFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application
{
    private static final Logger LOGGER = LogManager.getLogger(App.class);
    
    private static int mCount = 0;
    
    public static void main(
        final String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void init() throws Exception
    {
        LOGGER.info("init being called: " + getPid());
    }
    
    @Override
    public void start(
        final Stage primaryStage)
    {
        addShutdownHook();
        mCount++;
        LOGGER.info("App started! pid: " + getPid() + ", count: " + mCount);
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setId("clickme");
        btn.setText("Say 'Hello World'");
        btn.setOnAction(e -> LOGGER.info("Button clicked"));
        
        final StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    
    public static String getPid()
    {
        String pid = "unknown";
        final String jvmName = ManagementFactory.getRuntimeMXBean().getName();
        final int index = jvmName.indexOf('@');
        if (index != -1) 
        {
            pid = jvmName.substring(0, index);
        }
        return pid;
    }
    
    private static void addShutdownHook() 
    {
        final Thread hookThread = new Thread(()-> LOGGER.info("Application Exited"));
        hookThread.setName("exitlogger");
        Runtime.getRuntime().addShutdownHook(hookThread);
    }


}
