package net.guilhermelacerda.tests;

import net.guilhermelacerda.component.CipherFactory;
import net.guilhermelacerda.component.CipherStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Rot47CipherStrategyTest {

    @Test
    public void shouldReturnE6de() {
        CipherStrategy rot47 = CipherFactory.createRot47("test");
        assertEquals("E6DE", rot47.messageEncode());
    }

    @Test
    public void shouldReturnTest() {
        CipherStrategy rot47 = CipherFactory.createRot47("E6DE");
        assertEquals("test", rot47.messageEncode());
    }
}