package oving0;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloWorldTest {

    private HelloWorld helloWorld;

    @BeforeEach
    public void setUp() {
        helloWorld = new HelloWorld();
    }

    @Test
    public void testHelloWorld() {
        assertEquals("Hello World!", helloWorld.getHelloWorld());
    }

    @Test
    public void testHelloWorldLength() {
        assertEquals(12, helloWorld.getHelloWorldLength());
    }
}
