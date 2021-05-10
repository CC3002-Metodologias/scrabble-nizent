package cl.uchile.dcc.scrabble.models;

import java.util.Objects;

/**
 * Represents an Integer and its behavior
 * @author Nicolás Zenteno Guardia
 */
public class ScrabbleInt extends AbstractNumber<Integer> implements IInteger<Integer> {

    /**
     * Creates a new Scrabble Integer
     * @param value int parameter
     */
    public ScrabbleInt(int value) {
        super(value);
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
        String bin = toBinary((Integer) this.Value());
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
    private String positiveToBinary(int positiveInteger){
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
    private String twoComplement(String binaryString){
        StringBuilder comp = new StringBuilder(binaryString);
        for(int i = 0; i<binaryString.length(); i++){
            comp.setCharAt(i, (char) ('0'+'1'-(int) comp.charAt(i)));
        }

        for(int i = binaryString.length()-1; i>=0; i--){
            if(comp.charAt(i)=='0'){
                comp.setCharAt(i, '1');
                break;
            }
            comp.setCharAt(i,'0');
        }
        return comp.toString();
    }
}
