package com.solvd.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomThread extends Thread {
    private static final Logger logger = LogManager.getLogger(CustomThread.class.getName());
    protected final String name;
    private boolean isAvailable;


    public CustomThread(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    void connect(){
        logger.info("Connecting thread " + name);
        isAvailable = false;
    }

    void disconnect(){
        logger.info("Disconnecting thread " + name);
        isAvailable=true;
    }

    @Override
    public void run() {
        String myConnection = "";

        connect();

        logger.info(name + " uses " + myConnection);
        logger.info("<<<<< Started run() of " + name);

        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        logger.info("<<<<< Finished run() of " + name);

        disconnect();


    }
}
