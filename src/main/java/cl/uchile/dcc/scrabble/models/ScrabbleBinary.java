package cl.uchile.dcc.scrabble.models;

import java.util.Objects;


/**
 * This class represents a binary number and its behavior
 * @author Nicolás Zenteno Guardia
 */
public class ScrabbleBinary extends AbstractNumber implements IInteger {
    private String value;

    /**
     * Creates a new Binary number
     * @param value a String in 01 format
     */
    public ScrabbleBinary(String value){
        this.value = value;
    }

    /**
     * Returns the hash code of the class
     * @return class hash code
     */
    @Override
    public int hashCode(){
        return Objects.hash(ScrabbleBinary.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScrabbleBinary transformToScrabbleBinary() {
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScrabbleInt transformToScrabbleInt() {
        return new ScrabbleInt(toInt(String.valueOf(this.Value())));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScrabbleFloat transformToScrabbleFloat() {
        return new ScrabbleFloat(toInt(String.valueOf(this.Value())));
    }

    /**
     * Transforms a binary string into an int
     * @param binary a string with 0s and 1s
     * @return an int equivalent to the binary
     */
    public int toInt(String binary) {
        if (bitToInt(binary.charAt(0)) == 0) {
            return positiveBinToInt(binary);
        } else {
            return negativeBinaryToInt(binary);
        }
    }

    /**
     * Trnasforms negative binaries that starts with 1 into an int
     * @param binary a binary string with 0s and 1s
     * @return the negative int
     */
    private int negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return w;
    }

    /**
     * Transforms positive binaries that starts with 0 into an int
     * @param binary binary string with first character 0
     * @return the equivalent int
     */
    private int positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return w;
    }

    /**
     * Transforms a char of 0 or 1 into an int equivalent
     * @param bit '0' or '1' char
     * @return 1 or 0 equivalent to char
     */
    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    /**
     * Returns the value of the Scrabble Binary
     * @return value
     */
    @Override
    public Object Value() {
        return this.value;
    }
}
