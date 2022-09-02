package com.solvd.homework4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

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
