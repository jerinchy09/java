package reflection;

import design.patterns.Customer;
import design.patterns.SearchService;

import java.lang.reflect.Method;
import java.util.HashMap;

public class ReflectionMain {
    public static void main(String[] args) throws Exception {
        SearchService serviceService = SearchService.getInstance();
        ProxyTime proxyTime = new ProxyTime();

        ISearchService proxiedSearch = proxyTime.wrapInProxy(ISearchService.class, serviceService);
        proxiedSearch.getCustomerByFirstName("brandon");
        proxiedSearch.getCustomerByLastName("Alleyne");
    }
}
