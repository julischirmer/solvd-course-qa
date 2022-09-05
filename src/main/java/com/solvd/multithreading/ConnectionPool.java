package com.solvd.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Vector;
import java.util.concurrent.*;

public class ConnectionPool {

    public static final Integer maxThread = 5;
    private static final Logger logger = LogManager.getLogger(ConnectionPool.class.getName());
    private static ConnectionPool connectionPool;
    private int size;
    private Vector<Connection> connections;
    private int connectionsCount;

    public ConnectionPool(int size) {
        this.size = size;
        connections = new Vector<Connection>();
        connectionsCount = 0;
    }

    public static ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    private void addConnection(Connection connection) {
        connections.add(connection);
        connectionsCount++;
    }

    public void removeConnection(Connection connection) {
        connections.remove(connection);
    }

    public synchronized Connection getConnection() throws InterruptedException {
        Connection conn = null;

        if (connections.size() < size) {
            conn = new Connection("Thread: " + (connectionsCount + 1) + " -> Connection number: " + (connections.size() + 1));
            addConnection(conn);
            return conn;
        } else {
            logger.info("not available connections");
            int maxAttempts = 10;
            while (maxAttempts-- > 0) {
                Thread.sleep(1000);

                if (connections.size() < size) {
                    conn = new Connection("Thread: " + (connectionsCount + 1) + " -> connection number: " + (connections.size() + 1));
                    addConnection(conn);
                    return conn;
                }
            }
            throw new RuntimeException("No connections available after 10 seconds");
        }
    }



}
