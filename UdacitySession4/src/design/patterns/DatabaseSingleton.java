package design.patterns;

import java.util.Map;

public class DatabaseSingleton {

    public static DatabaseSingleton databaseSingleton;
    private DatabaseSingleton(){
        connectToDatabase();
    }

    private void connectToDatabase(){

    }

    public void loadCustomers(Map<String, Customer> customerMap){
        Customer customer1 = new Customer("brandon", "Alleyne", 17);
        Customer customer2 = new Customer("george", "Jefferson", 27);
        Customer customer3 = new Customer("shaqueilla", "Seale", 52);
        Customer customer4 = new Customer("alisha", "Bryant", 72);
        Customer customer5 = new Customer("tiger", "Woods", 35);
        Customer customer6 = new Customer("scotia", "Bank", 29);
        customerMap.put(customer1.getFname(), customer1);
        customerMap.put(customer2.getFname(), customer2);
        customerMap.put(customer3.getFname(), customer3);
        customerMap.put(customer4.getFname(), customer4);
        customerMap.put(customer5.getFname(), customer5);
        customerMap.put(customer6.getFname(), customer6);

        for(int i = 0; i<100000; i++){
            customerMap.put("randomKey"+i, new Customer("random", "random", 7));
        }
    }

    public static DatabaseSingleton getInstance(){
        if (databaseSingleton == null) {
            databaseSingleton = new DatabaseSingleton();
        }
        return databaseSingleton;
    }

}
