package cl.uchile.dcc.scrabble.models;

import java.util.Objects;

/**
 * Represents an Integer and its behavior
 * @author Nicolás Zenteno Guardia
 */
public class ScrabbleInt extends AbstractNumber implements IInteger, IStandard {
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
        return Objects.hash(this.value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ScrabbleFloat transformToScrabbleFloat(){
        return new ScrabbleFloat(Double.valueOf(this.toString()));
    }

    /**
     * Sums a Scrabble int
     * @param scrabbleInt the Scrabble Int object
     * @return A Scrabble Int containing the sum between both values
     */
    @Override
    public INumber sumInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleInt(this.value+scrabbleInt.Value());
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
        return new ScrabbleInt(this.value);
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
    public Integer Value() {
        return this.value;
    }

    /**
     * Set value of Scrabble Int
     * @param value int
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @inheritDoc
     */
    @Override
    public ScrabbleString transformToScrabbleString() {
        return new ScrabbleString(this.toString());
    }

    /**
     * Transform the value of the ScrabbleType to an String
     * @return the String containing the value
     */
    @Override
    public String toString() {
        return Integer.valueOf(this.value).toString();
    }

    @Override
    public IInteger sumBinary(ScrabbleBinary scrabbleBinary) {
        return (new ScrabbleInt(this.value+scrabbleBinary.toInt())).transformToScrabbleBinary();
    }

    @Override
    public IInteger subtractToBinary(ScrabbleBinary scrabbleBinary) {
        return (new ScrabbleInt(scrabbleBinary.toInt()-this.value)).transformToScrabbleBinary();
    }

    @Override
    public INumber subtractToInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleInt(scrabbleInt.Value()-this.value);
    }

    @Override
    public INumber divideToInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleInt(scrabbleInt.Value()/this.value);
    }

    @Override
    public INumber multiplyInt(ScrabbleInt scrabbleInt) {
        return (new ScrabbleInt(scrabbleInt.Value()*this.value));
    }

    @Override
    public IInteger divideToBinary(ScrabbleBinary scrabbleBinary) {
        return (new ScrabbleInt(scrabbleBinary.toInt()/this.value)).transformToScrabbleBinary();
    }

    @Override
    public IInteger multiplyBinary(ScrabbleBinary scrabbleBinary) {
        return (new ScrabbleInt(scrabbleBinary.toInt()*this.value)).transformToScrabbleBinary();
    }

    @Override
    public IStandard sumFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(this.value+scrabbleFloat.Value());
    }

    @Override
    public INumber sum(IStandard iNumber) {
        return iNumber.sumInt(this);
    }

    @Override
    public INumber subtractToFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()-this.value);
    }

    @Override
    public INumber subtract(IStandard iNumber) {
        return iNumber.subtractToInt(this);
    }

    @Override
    public INumber divideFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()/this.value);
    }

    @Override
    public INumber divideBy(IStandard iStandard) {
        return iStandard.divideToInt(this);
    }

    @Override
    public INumber sum(IEncodedInteger iEncodedInteger) {
        return iEncodedInteger.sumInt(this);
    }

    @Override
    public INumber subtract(IEncodedInteger iEncodedInteger) {
        return iEncodedInteger.subtractToInt(this);
    }

    @Override
    public INumber divideBy(IEncodedInteger iEncodedInteger) {
        return iEncodedInteger.divideToInt(this);
    }

    @Override
    public INumber multiplyFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()*this.value);
    }

    @Override
    public INumber multiplyBy(IStandard iStandard) {
        return iStandard.multiplyInt(this);
    }

    @Override
    public INumber multiplyBy(IEncodedInteger iEncodedInteger) {
        return iEncodedInteger.multiplyInt(this);
    }
}
