package com.solvd.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Vector;
import java.util.concurrent.*;

public class ConnectionPool {

    private static final Logger logger = LogManager.getLogger(ConnectionPool.class.getName());
    private static ConnectionPool connectionPool;
    private int size;
    private Vector<Connection> connections;

    public ConnectionPool(int size) {
        this.size = size;
        connections = new Vector<Connection>();
    }

    public static ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    private void addConnection(Connection connection) {
        connections.add(connection);
    }

    public void removeConnection(Connection connection) {
        connections.remove(connection);
    }

    public synchronized Connection getConnection() throws InterruptedException {
        Connection conn = null;

        if (connections.size() < size) {
            conn = new Connection("Thread: " + (Thread.currentThread().getId() % size));
            addConnection(conn);
            return conn;
        } else {
            logger.info("not available connections");
            int maxAttempts = 10;
            while (maxAttempts-- > 0) {
                Thread.sleep(1000);

                if (connections.size() < size) {
                    conn = new Connection("Thread: " + (Thread.currentThread().getId() % size));
                    addConnection(conn);
                    return conn;
                }
            }
            throw new RuntimeException("No connections available after 10 seconds");
        }
    }

}