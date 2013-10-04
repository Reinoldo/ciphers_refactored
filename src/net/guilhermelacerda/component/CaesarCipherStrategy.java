package net.guilhermelacerda.component;

public class CaesarCipherStrategy extends CipherStrategy {
    private static final int ALPHABET_LETTERS = 26;
    private static final int SHIFT = 3;
    private CipherType ct;

    public CaesarCipherStrategy(Cipher cipher) {
        super(cipher);
    }

    private void setCipherType(CipherType ct) {
        this.ct = ct;
    }

    private CipherType getCipherType() {
        return ct;
    }

    public String encode() {
        setCipherType(CipherType.CRIPT);
        return doRotate();
    }

    public String decode() {
        setCipherType(CipherType.DECRIPT);
        return doRotate();
    }

    protected String doRotate() {
        char[] msgLetters = getCipher().getMessageToChar();

        for (int position = 0; position < msgLetters.length; position++) {
            getCipher().setAsciiCode(msgLetters[position]);
            char letter = ((isAlphabetLetter()) ? rotate()	: msgLetters[position]);
            getCipher().addLetter(letter, position);
        }

        return getCipher().toString();
    }

    private boolean isAlphabetLetter() {
        return getCipher().getAsciiCode() >= 'a' && getCipher().getAsciiCode() <= 'z';
    }

    private char rotate() {
        return (char) (getCipherType() == CipherType.CRIPT ? cript() : decript());
    }

    private int cript() {
        return (getCipher().getAsciiCode() + SHIFT <= 'w') ?
                (getCipher().getAsciiCode() + SHIFT) :
                (getCipher().getAsciiCode()	- ALPHABET_LETTERS + SHIFT);
    }

    private int decript() {
        return (getCipher().getAsciiCode() >= 'd' && getCipher().getAsciiCode() <= 'w') ?
                (getCipher().getAsciiCode() - SHIFT) :
                (ALPHABET_LETTERS + getCipher().getAsciiCode() - SHIFT);
    }
}
