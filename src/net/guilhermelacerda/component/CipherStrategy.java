package net.guilhermelacerda.component;

public abstract class CipherStrategy implements CipherAction {
    private Cipher cipher;

    protected CipherStrategy(Cipher cipher) {
        this.cipher = cipher;
    }

    public String messageEncode() {
        return encode();
    }

    public String messageDecode() {
        return decode();
    }

    public Cipher getCipher() {
        return cipher;
    }

    protected abstract String doRotate();
}
