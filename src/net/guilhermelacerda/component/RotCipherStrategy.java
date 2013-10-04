package net.guilhermelacerda.component;

abstract public class RotCipherStrategy extends CipherStrategy
                            implements Rotatable {
    private int[] elements;

    protected RotCipherStrategy(Cipher cipher) {
        super(cipher);
        elements = this.getElements();
    }

    public String encode() {
        return doRotate();
    }

    public String decode() {
        return doRotate();
    }

    protected String doRotate() {
        char[] msgLetters = getCipher().getMessageToChar();

        for (int position = 0; position < msgLetters.length; position++) {
            getCipher().setAsciiCode(msgLetters[position]);
            rotatePart();
            getCipher().addLetter((char) getCipher().getAsciiCode(), position);
        }
        return getCipher().toString();
    }

    private void rotatePart() {
        if (isFirstPart())
            getCipher().setAsciiCode(getCipher().getAsciiCode()
                    + getShift());
        else if (isSecondPart())
            getCipher().setAsciiCode(getCipher().getAsciiCode() - getShift());
    }

    private boolean isFirstPart() {
        return getCipher().getAsciiCode() >= getElement(Rotatable.ELEMENT_1) &&
                getCipher().getAsciiCode() <= getElement(Rotatable.ELEMENT_2);
    }

    private boolean isSecondPart() {
        return getCipher().getAsciiCode() >= getElement(Rotatable.ELEMENT_3) &&
                getCipher().getAsciiCode() <= getElement(Rotatable.ELEMENT_4);
    }

    private int getElement(int position) {
        return elements[position];
    }
}
