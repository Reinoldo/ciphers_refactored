package net.guilhermelacerda.component;

class Rot13CipherStrategy extends RotCipherStrategy {
    private static final int SHIFT_13 = 13;

    protected Rot13CipherStrategy(Cipher cipher) {
        super(cipher);
    }

    @Override
    public int getShift() {
        return SHIFT_13;
    }

    @Override
    public int[] getElements() {
        return new int[]{'a', 'm', 'n', 'z'};
    }
}
