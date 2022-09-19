package com.solvd.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;


public class ClientsRunner {
    private static final Logger logger = LogManager.getLogger(ClientsRunner.class.getName());
    private static ConnectionPool connectionPool = new ConnectionPool(5);
    static final int MaxThread = 5;
    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(MaxThread);
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(MaxThread, MaxThread, 4, TimeUnit.SECONDS, queue);
        ClientsRunner clientsRunner = new ClientsRunner();

        CompletableFuture<Void> future = CompletableFuture.runAsync(()->PoolTask(executor1));
        CompletableFuture<Void> futureRunner = CompletableFuture.runAsync(clientsRunner.new RunnerTask(), executor1);
        futureRunner.join();
        CompletableFuture<Void> futureRunnerTaskThread = CompletableFuture.runAsync(clientsRunner.new RunnerTaskThread(), executor1);
        futureRunnerTaskThread.join();


        future.whenComplete((x,y)-> executor1.shutdown()).thenRun(()-> logger.info("Finished all threads"));

        for (int i = 0; i < MaxThread; i++) {
            Runnable connection = new Runnable() {
                @Override
                public void run() {
                    try{
                        Connection connection = connectionPool.getConnection();
                        connection.connect();
                        try{
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        connection.disconnect();
                        connectionPool.removeConnection(connection);
                    }catch (RuntimeException | InterruptedException e){
                        System.err.println(e.getMessage());
                    }
                }
            };
            executor1.execute(connection);
        }
        executor1.shutdown();
        while (!executor1.isTerminated()){

        }
        System.out.println("All threads finished");
    }

    class RunnerTask implements Runnable{
        public void run() {
            try{
                Connection connection = connectionPool.getConnection();
                connection.connect();
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                connection.disconnect();
                connectionPool.removeConnection(connection);
            }catch (RuntimeException | InterruptedException e){
                System.err.println(e.getMessage());
            }
        }
    }

    class RunnerTaskThread extends Thread{
        public void run(){
            try{
                Connection connection = connectionPool.getConnection();
                connection.connect();
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                connection.disconnect();
                connectionPool.removeConnection(connection);
            }catch (RuntimeException | InterruptedException e){
                System.err.println(e.getMessage());
            }
        }
    }

    public static void PoolTask(ThreadPoolExecutor executor1){
        for (int i = 0; i < MaxThread; i++)
        {
            executor1.execute(() -> {
                try{
                    Connection connection = connectionPool.getConnection();
                    connection.connect();
                    try{
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    connection.disconnect();
                    connectionPool.removeConnection(connection);
                }catch (RuntimeException | InterruptedException e){
                    System.err.println(e.getMessage());
                }
            });
        }
    }
}
