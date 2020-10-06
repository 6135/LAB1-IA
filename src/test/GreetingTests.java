
package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import app.*;
public class GreetingTests {
    @Test
    public void testGreeting() {
        assertEquals("hello!", new Greeting().getGreeting());
        assertNotEquals("Hello!", new Greeting().getGreeting());
    }
}
