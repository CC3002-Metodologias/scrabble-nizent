package cl.uchile.dcc.scrabble.models;

import java.util.Objects;

/**
 * Represents an Integer and its behavior
 * @author Nicolás Zenteno Guardia
 */
public class ScrabbleInt extends AbstractNumber implements IInteger {
    private int value;

    /**
     * Creates a new Scrabble Integer
     * @param value int parameter
     */
    public ScrabbleInt(int value) {
        this.value = value;
    }

    /**
     * Returns the has code of the class
     * @return class hash code
     */
    @Override
    public int hashCode(){
        return Objects.hash(ScrabbleInt.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScrabbleFloat transformToScrabbleFloat(){
        return new ScrabbleFloat(Float.valueOf(this.toString()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScrabbleBinary transformToScrabbleBinary() {
        String bin = toBinary(Integer.valueOf(this.toString()));
        return new ScrabbleBinary(bin);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScrabbleInt transformToScrabbleInt() {
        return this;
    }

    /**
     * Transform an integer to its equivalent binary string format
     * @param integer value
     * @return binary string
     */
    private String toBinary(int integer){
        int abs = Math.abs(integer);
        String bin = positiveToBinary(abs);
        if(integer<0){
            bin = twoComplement(bin);
        }
        return bin;
    }

    /**
     * Transforms a positive integer into a binary string
     * @param positiveInteger positive integer
     * @return binary string starting with 0
     */
    private static String positiveToBinary(int positiveInteger){
        StringBuilder bin = new StringBuilder();
        while (positiveInteger != 0) {
            bin.insert(0, positiveInteger % 2);
            positiveInteger = positiveInteger / 2;
        }
        bin.insert(0, 0);
        return bin.toString();
    }

    /**
     * Calculates the 2 complement of the binary string
     * @param binaryString string with '0' or '1's
     * @return The complement of two represented by a string
     */
    private static String twoComplement(String binaryString){
        StringBuilder comp = new StringBuilder(binaryString);
        int length = binaryString.length();
        for(int i = 0; i<length; i++){
            comp.setCharAt(i, complement(comp.charAt(i)));
        }

        for(int i = length-1; i>=0; i--){
            if(comp.charAt(i)=='0'){
                comp.setCharAt(i, '1');
                break;
            }
            comp.setCharAt(i,'0');
        }
        return comp.toString();
    }

    /**
     * Transforms a '0' or '1' char into its complement
     * @param character a char object
     * @return complement
     */
    private static char complement(char character){
        return character == '1' ? '0' : '1';
    }

    /**
     * Returns the value of the Scrabble Int
     * @return value
     */
    @Override
    public Object Value() {
        return this.value;
    }
}
