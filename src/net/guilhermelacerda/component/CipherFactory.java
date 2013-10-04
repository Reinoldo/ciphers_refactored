package net.guilhermelacerda.component;

public final class CipherFactory {
    private CipherFactory() {
    }

    public static CipherStrategy createCaesar(String msg) {
        return new CaesarCipherStrategy(new Cipher(msg));
    }

    public static CipherStrategy createRot13(String msg) {
        return new Rot13CipherStrategy(new Cipher(msg));
    }

    public static CipherStrategy createRot47(String msg) {
        return new Rot47CipherStrategy(new Cipher(msg));
    }

    public static CipherStrategy createVigenere(String msg, String key) {
        return new VigenereCipherStrategy(new Cipher(msg), key);
    }
}
