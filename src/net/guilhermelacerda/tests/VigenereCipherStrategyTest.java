package net.guilhermelacerda.tests;

import net.guilhermelacerda.component.CipherFactory;
import net.guilhermelacerda.component.CipherStrategy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VigenereCipherStrategyTest {

    @Test
    public void shouldReturnMikm() {
        CipherStrategy vigenere = CipherFactory.createVigenere("test", "test");
        assertEquals("mikm", vigenere.messageEncode());
    }

    @Test
    public void shouldReturnTest() {
        CipherStrategy vigenere = CipherFactory.createVigenere("mikm", "test");
        assertEquals("test", vigenere.messageDecode());
    }
}
