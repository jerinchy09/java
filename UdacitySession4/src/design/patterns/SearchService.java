package design.patterns;

import reflection.ISearchService;

import javax.naming.PartialResultException;
import java.awt.print.PrinterAbortException;
import java.io.InvalidClassException;
import java.util.HashMap;
import java.util.Map;

public class SearchService implements ISearchService {
    private DatabaseSingleton databaseSingleton = DatabaseSingleton.getInstance();
    private static SearchService searchService;
    private Map<String, Customer> customerMap = new HashMap<>();
    private SearchService() {
        databaseSingleton.loadCustomers(customerMap);
    }

    @Override
    public Customer getCustomerByFirstName(String fname) throws Exception {
        if (fname == null) {
            throw new Exception("String is null");
        }

        return customerMap.get(fname.toLowerCase());
    }

    @Override
    public Customer getCustomerByLastName(String lname) throws Exception{
        if (lname == null) {
            throw new Exception("String is null");
        }
        
        return customerMap.values().stream()
                                   .filter(x-> x.getLname().equals(lname))
                                   .findFirst()
                                   .get();
    }

    public static SearchService getInstance(){
        if (searchService == null) {
            searchService = new SearchService();
        }
        return searchService;
    }
}
