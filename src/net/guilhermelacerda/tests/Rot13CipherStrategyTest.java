package net.guilhermelacerda.tests;

import net.guilhermelacerda.component.CipherFactory;
import net.guilhermelacerda.component.CipherStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Rot13CipherStrategyTest {

    @Test
    public void shouldReturnGrfg() {
        CipherStrategy rot13 = CipherFactory.createRot13("test");
        assertEquals("grfg", rot13.messageEncode());
    }

    @Test
    public void shouldReturnTest() {
        CipherStrategy rot13 = CipherFactory.createRot13("grfg");
        assertEquals("test", rot13.messageEncode());
    }
}
