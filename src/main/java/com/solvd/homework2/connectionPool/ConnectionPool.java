package com.solvd.homework2.connectionPool;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool {

    private static final Logger logger = LogManager.getLogger(ConnectionPool.class.getName());
    private static ConnectionPool cp;
    private BlockingQueue<String> connections;
    private Integer connectionsCount;
    public static final Integer POOL_SIZE = 5;

    private ConnectionPool(){
        connections = new LinkedBlockingQueue<String>(POOL_SIZE);
        connectionsCount = 0;
    };

    public static ConnectionPool getInstance(){
        if(cp == null){
            synchronized (ConnectionPool.class){
                if(cp == null)
                {
                    cp = new ConnectionPool();
                }
            }
        }
        return cp;
    }


    private void initConnection() {
        connections.add("Connection " + (++connectionsCount));
    }

    public String getConnection() throws InterruptedException {
        if(connections.size() == 0 && connectionsCount < POOL_SIZE ) {
            synchronized (ConnectionPool.class){
                if(connections.size() == 0 && connectionsCount < POOL_SIZE ) {
                    initConnection();
                }
            }
        }
        return connections.take();
    }

    public void releaseConnection(String connectionReleased) {
        connections.offer(connectionReleased);
    }
}
