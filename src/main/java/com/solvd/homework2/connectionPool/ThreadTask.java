package com.solvd.homework2.connectionPool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class ThreadTask extends Thread {
    private static final Logger logger = LogManager.getLogger(ThreadTask.class.getName());
    // public static final Integer POOL_SIZE = 7;
    private String name;
    private ConnectionPool cp;

    public ThreadTask() {

    }

    public ThreadTask(String threadName, ConnectionPool cp) {
        super();
        this.name = threadName;
        this.cp = cp;
    }

    public void start() {
        this.run();
    }



    public void run() {
        try {
            String myConnection = "";
            myConnection = cp.getConnection();
            logger.info("Thread #" + name + " get a connection successfully");
        } catch (Exception e) {
            logger.error(e);
        }

    }
}
