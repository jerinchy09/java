package concurrency;

import design.patterns.Customer;
import design.patterns.DatabaseSingleton;

import java.util.HashMap;
import java.util.Map;

public class ThreadsMain {
    final static DatabaseSingleton databaseSingleton = DatabaseSingleton.getInstance();

    final static Map<String, Customer> customerMap = new HashMap<>();
    public static void main(String[] args) throws InterruptedException {
        Thread databaseThread = new Thread(){
            @Override
            public void run() {
                databaseSingleton.loadCustomers(customerMap);
            }
        };



        Thread countCustomers = new Thread(){
            @Override
            public void run() {
                System.out.println(customerMap.entrySet().stream().count());
            }
        };

        databaseThread.start();
        databaseThread.join();
        countCustomers.start();
        countCustomers.join();
    }
}
