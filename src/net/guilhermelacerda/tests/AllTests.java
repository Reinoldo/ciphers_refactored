package net.guilhermelacerda.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CipherTest.class, CaesarCipherStrategyTest.class,
            Rot13CipherStrategyTest.class, Rot47CipherStrategyTest.class,
            VigenereCipherStrategyTest.class })
public class AllTests {
}
