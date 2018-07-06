package com.github.liamsharp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
    private static final Logger LOGGER = LogManager.getLogger(App.class);
    
    public static void main(
        final String[] args) 
    {
        LOGGER.info("Hello world!");
    }

    public static int returnOne()
    {
        return 1;
    }

}
