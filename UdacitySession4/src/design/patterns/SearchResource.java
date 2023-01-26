package design.patterns;

import java.awt.print.PrinterAbortException;
import java.io.InvalidClassException;

public class SearchResource {
     private static SearchResource searchResource;
     private SearchService searchService = SearchService.getInstance();

     private SearchResource(){}
     public Customer getCustomerByFirstName(String fname) {
         try {
             return searchService.getCustomerByFirstName(fname);
         } catch (Exception e) {
             System.out.println("Failed to retrieve customer");
             throw new RuntimeException(e);
         }
     }

    public Customer getCustomerByLastName(String lname) {
        try {
            return searchService.getCustomerByLastName(lname);
        } catch (Exception e) {
            System.out.println("Failed to retrieve customer");
            throw new RuntimeException(e);
        }
    }

     public static SearchResource getInstance() {
         if (searchResource == null) {
             searchResource = new SearchResource();
         }
         return searchResource;
     }
}
