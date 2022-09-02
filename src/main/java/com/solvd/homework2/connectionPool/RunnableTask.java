package com.solvd.homework4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableTask implements Runnable{
    private static final Logger logger = LogManager.getLogger(RunnableTask.class.getName());

    private String name;
    private ConnectionPool cp;

    public RunnableTask() {

    }

    public RunnableTask(String threadName, ConnectionPool cp){
        this.name = threadName;
        this.cp = cp;
    }

    @Override
    public void run() {
        String myConnection = "";
        try {
            myConnection = cp.getConnection();
            logger.info("Runnable #" + name + " got a connection successfully" + myConnection);
        } catch (Exception e) {
            logger.error(e);
        }

    }
}
