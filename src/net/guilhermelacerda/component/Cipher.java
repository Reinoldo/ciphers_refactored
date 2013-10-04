package net.guilhermelacerda.component;

public class Cipher {
    private String message;
    private char[] cipheredMsg;
    private int asciiCode;

    public Cipher(String message) {
        setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        cipheredMsg = new char[this.getMessage().length()];
    }

    public char[] getCipheredMsg() {
        return cipheredMsg;
    }

    public int getAsciiCode() {
        return asciiCode;
    }

    public void setAsciiCode(int asciiCode) {
        this.asciiCode = asciiCode;
    }

    public void addLetter(char letter, int position) {
        if (position > cipheredMsg.length)
            throw new IndexOutOfBoundsException("invalid position for array char...");
        cipheredMsg[position] = letter;
    }

    public char getLetterFrom(int position) {
        if (position > cipheredMsg.length)
            throw new IndexOutOfBoundsException("invalid position for array char...");
        return cipheredMsg[position];
    }

    public char[] getMessageToChar() {
        return getMessage().toCharArray();
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder();
        for (int x = 0; x < this.getCipheredMsg().length; x++)
            msg.append(this.cipheredMsg[x]);
        return msg.toString();
    }
}
