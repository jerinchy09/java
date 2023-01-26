package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;
import java.util.TimeZone;

public class TimeInterceptor implements InvocationHandler {
    private Object targetObject;
    public <T> TimeInterceptor(T delegate){
        this.targetObject = delegate;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Instant startTime = Instant.now();
        Object result = null;
        try {
            result = method.invoke(targetObject, args);
        } catch (IllegalAccessException ie){
            throw new RuntimeException(ie);
        } catch (InvocationTargetException ite) {
            throw ite.getTargetException();
        } finally {
            final Duration elapsed = Duration.between(startTime, Instant.now());
            System.out.println("Method: " + method.getName() + ". Time to execute: " + elapsed.getNano());
        }

        return result;
    }
}
