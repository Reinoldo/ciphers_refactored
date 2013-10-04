package net.guilhermelacerda.component;

class Rot47CipherStrategy extends RotCipherStrategy {
    private static final int SHIFT_47 = 47;

    protected Rot47CipherStrategy(Cipher cipher) {
        super(cipher);
    }

    @Override
    public int getShift() {
        return SHIFT_47;
    }

    @Override
    public int[] getElements() {
        return new int[]{'!', 'O', 'P', '~'};
    }
}
