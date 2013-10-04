package net.guilhermelacerda.tests;

import net.guilhermelacerda.component.CipherFactory;
import net.guilhermelacerda.component.CipherStrategy;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CaesarCipherStrategyTest {

    @Test
    public void shouldReturnWhvw() {
        CipherStrategy caesar = CipherFactory.createCaesar("test");
        assertEquals("whvw", caesar.messageEncode());
    }

    @Test
    public void shouldReturnTest() {
        CipherStrategy caesar = CipherFactory.createCaesar("whvw");
        assertEquals("test", caesar.messageDecode());
    }
}
