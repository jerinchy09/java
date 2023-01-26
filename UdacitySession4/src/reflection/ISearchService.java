package reflection;

import design.patterns.Customer;

public interface ISearchService {
    public Customer getCustomerByFirstName(String fname) throws Exception;
    public Customer getCustomerByLastName(String lname) throws Exception;
}
