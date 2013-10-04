package net.guilhermelacerda.tests;

import net.guilhermelacerda.component.Cipher;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CipherTest {
    private Cipher c;
    private static final String MESSAGE = "test message";

    @Before
    public void setUp() {
        c = new Cipher(MESSAGE);
        c.setAsciiCode(65);
    }

    @Test
    public void testGetMessage() {
        assertEquals(MESSAGE, c.getMessage());
    }

    @Test
    public void testGetAsciiCode() {
        assertEquals(65, c.getAsciiCode());
    }

    @Test
    public void testAddAndGetLetter() {
        c.addLetter('a', 0);
        assertEquals('a', c.getLetterFrom(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddLetterOutOfBounds() {
        c.addLetter('a', 14);
    }

    @Test
    public void testGetMessageToChar() {
        assertArrayEquals(MESSAGE.toCharArray(), c.getMessageToChar());
    }
}
