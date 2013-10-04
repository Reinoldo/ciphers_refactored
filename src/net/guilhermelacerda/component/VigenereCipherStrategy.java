package net.guilhermelacerda.component;

class VigenereCipherStrategy extends CipherStrategy {
    private String key;
    private CipherType ct;
    private static final int START_UPPERCASE = 65;
    private static final int START_LOWERCASE = 97;
    private static final int ALPHABET_LETTERS = 26;
    private static final int ALPHABET_DIFF = 25;

    protected VigenereCipherStrategy(Cipher cipher, String key) {
        super(cipher);
        setKey(key);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private void setCipherType(CipherType ct) {
        this.ct = ct;
    }

    private CipherType getCipherType() {
        return ct;
    }

    @Override
    public String encode() {
        setCipherType(CipherType.CRIPT);
        return doRotate();
    }

    @Override
    public String decode() {
        setCipherType(CipherType.DECRIPT);
        return doRotate();
    }

    @Override
    protected String doRotate() {
        getCipher().setMessage(removeSpaces(getCipher().getMessage()));
        rotate();

        return getCipher().toString();
    }

    private void rotate() {
        String withoutSpaces = getCipher().getMessage();
        String newKey = generateNewKey();

        for (int position = 0; position < withoutSpaces.length(); position++) {
            char msgLetter = withoutSpaces.charAt(position);
            char keyLetter = newKey.charAt(position);

            getCipher().addLetter(getLetterFromGridVigenere(msgLetter, keyLetter), position);
        }
    }

    private String removeSpaces(String msg) {
        StringBuilder withoutSpaces = new StringBuilder();
        for (int position = 0; position < msg.length(); position++) {
            char letter = msg.charAt(position);
            if (letter == ' ')
                continue;
            withoutSpaces.append(letter);
        }

        return withoutSpaces.toString();
    }

    private String generateNewKey() {
        int lenKeyWithoutSpaces = removeSpaces(getKey()).length();
        int position = 0;
        int lenMessageWithoutSpaces = getCipher().getMessage().length();
        int count = Math.max(lenMessageWithoutSpaces, lenKeyWithoutSpaces);
        StringBuilder newKey = new StringBuilder();

        for(int x = 0; x < count; x++ ) {
            newKey.append(getKey().charAt(position));
            position++;
            if (position == lenKeyWithoutSpaces)
                position = 0;
        }

        return newKey.toString();
    }

    private int getFactor(char letter) {
        int factor = 0;
        if (isUpperCase(letter)) factor = START_UPPERCASE;
        if (isLowerCase(letter)) factor = START_LOWERCASE;

        return factor;
    }

    private boolean isUpperCase(char letter) {
        return letter >= 'A' && letter <= 'Z';
    }

    private boolean isLowerCase(char letter) {
        return letter >= 'a' && letter <= 'z';
    }

    private char getLetterFromGridVigenere(char msgLetter, char keyLetter) {
        int msgFactor = getFactor(msgLetter);
        int keyFactor = getFactor(keyLetter);

        return (char) calculateGridPosition(msgLetter, keyLetter, msgFactor,
                keyFactor);
    }

    private int calculateGridPosition(char msgLetter, char keyLetter,
                                      int msgFactor, int keyFactor) {
        int result = 0;

        if (getCipherType() == CipherType.CRIPT) {
            result = msgLetter + keyLetter - keyFactor;
            if (result > (msgFactor + ALPHABET_DIFF))
                result -= ALPHABET_LETTERS;
        } else {
            result = msgLetter - keyLetter + keyFactor;
            if (result < msgFactor)
                result += ALPHABET_LETTERS;
        }
        return result;
    }
}
