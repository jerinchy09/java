package reflection;

import java.lang.reflect.Proxy;

public class ProxyTime {
    public <T> T wrapInProxy(Class<T> klass, T delegate) {
        Object proxy = Proxy.newProxyInstance(
                klass.getClassLoader(),
                new Class<?>[]{klass},
                new TimeInterceptor(delegate)
        );

        return  (T) proxy;
    }
}
