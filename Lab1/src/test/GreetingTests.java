
package test;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import app.*;
import *.java;
public class GreetingTests {

    @Test
    public void testGreeting() {
        assertEquals("hello!", new Greeting().getGreeting());
        assertEquals("Hello!", new Greeting().getGreeting());
    }
}
