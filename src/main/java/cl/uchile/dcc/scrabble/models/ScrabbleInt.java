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
     * Transform the ScrabbleInt into a ScrabbleFloat
     * @return a new ScrabbleFloat containing the ScrabbleInt value
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
    public INumber sumToInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleInt(this.value+scrabbleInt.Value());
    }

    /**
     * Transforms the ScrabbleInt into a ScrabbleBinary
     * @return a new ScrabbleBinary containing the equivalent binary String
     */
    @Override
    public ScrabbleBinary transformToScrabbleBinary() {
        String bin = toBinary(Integer.valueOf(this.toString()));
        return new ScrabbleBinary(bin);
    }

    /**
     * Transforms the ScrabbleInt into a ScrabbleInt
     * @return a new equivalent ScrabbleInt
     */
    @Override
    public ScrabbleInt transformToScrabbleInt() {
        return new ScrabbleInt(this.value);
    }

    /**
     * Transform an int to its equivalent binary string format
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
     * Transforms a positive int into a binary string
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
    public int Value() {
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
     * Transforms the ScrabbleInt into a ScrabbleString
     * @return a new ScrabbleString containing the ScrabbleInt value as a String
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

    /**
     * Sums a ScrabbleBinary
     * @param scrabbleBinary the ScrabbleBinary object
     * @return
     *      a new ScrabbleBinary containing the sum between the int
     *      value and the ScrabbleBinary binary String int value
     */
    @Override
    public IInteger sumToBinary(ScrabbleBinary scrabbleBinary) {
        return (new ScrabbleInt(this.value+scrabbleBinary.toInt())).transformToScrabbleBinary();
    }

    /**
     * Subtracts to a ScrabbleBinary
     * @param scrabbleBinary the ScrabbleBinary object
     * @return
     *      a new ScrabbleBinary containing the binary representation of
     *      ScrabbleBinary int equivalent value minus the ScrabbleInt value
     */
    @Override
    public IInteger subtractToBinary(ScrabbleBinary scrabbleBinary) {
        return (new ScrabbleInt(scrabbleBinary.toInt()-this.value)).transformToScrabbleBinary();
    }

    /**
     * Subtracts to a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return
     *      a new ScrabbleInt containing the result of
     *      Input ScrabbleInt value minus the ScrabbleInt value
     */
    @Override
    public INumber subtractToInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleInt(scrabbleInt.Value()-this.value);
    }

    /**
     * Divides a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return
     *      a new ScrabbleInt containing the int result of
     *      Input ScrabbleInt value divided by the ScrabbleInt value
     */
    @Override
    public INumber divideToInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleInt(scrabbleInt.Value()/this.value);
    }

    /**
     * Multiplies a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return
     *      a new ScrabbleInt containing the result of the multiplication of its values
     */
    @Override
    public INumber multiplyToInt(ScrabbleInt scrabbleInt) {
        return (new ScrabbleInt(scrabbleInt.Value()*this.value));
    }

    /**
     * Divides a ScrabbleBinary
     * @param scrabbleBinary the ScrabbleBinary object
     * @return
     *      a new ScrabbleBinary containing the binary representation of the result of
     *      ScrabbleBinary input int value divided by the ScrabbleInt value
     */
    @Override
    public IInteger divideToBinary(ScrabbleBinary scrabbleBinary) {
        return (new ScrabbleInt(scrabbleBinary.toInt()/this.value)).transformToScrabbleBinary();
    }

    /**
     * Multiplies a ScrabbleBinary
     * @param scrabbleBinary the ScrabbleBinary object
     * @return
     *      a new ScrabbleBinary with the binary representation of
     *      the multiplication of its values
     */
    @Override
    public IInteger multiplyToBinary(ScrabbleBinary scrabbleBinary) {
        return (new ScrabbleInt(scrabbleBinary.toInt()*this.value)).transformToScrabbleBinary();
    }

    /**
     * Sums a ScrabbleFloat
     * @param scrabbleFloat the Scrabble Float object
     * @return a new ScrabbleFloat containing the sum of values
     */
    @Override
    public INumber sumToFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(this.value+scrabbleFloat.Value());
    }

    /**
     * Sums an INumber number
     * @param iNumber the INumber object
     * @return a new INumber object containing the result
     */
    @Override
    public INumber sum(INumber iNumber) {
        return iNumber.sumToInt(this);
    }

    /**
     * Subtracts to a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new ScrabbleFloat containing the subtraction
     */
    @Override
    public INumber subtractToFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()-this.value);
    }

    /**
     * Subtracts an INumber number
     * @param iNumber the INumber object
     * @return
     *      a new INumber containing the subtraction
     *      result of the ScrabbleInt value minus input value
     */
    @Override
    public INumber subtract(INumber iNumber) {
        return iNumber.subtractToInt(this);
    }

    /**
     * Divide a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return
     *      a new ScrabbleFloat containing the result
     *      of the division of values
     */
    @Override
    public INumber divideToFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()/this.value);
    }

    /**
     * Divides the ScrabbleInt by an INumber number
     * @param iNumber the INumber object
     * @return a new INumber containing the division result
     */
    @Override
    public INumber divideBy(INumber iNumber) {
        return iNumber.divideToInt(this);
    }

    /**
     * Multiplies a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return
     *      a new ScrabbleFloat containing the result of multiplication
     *      between values
     */
    @Override
    public INumber multiplyToFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()*this.value);
    }

    /**
     * Multiplies an INumber number
     * @param iNumber the INumber object
     * @return a new INumber containing the multiplication result
     */
    @Override
    public INumber multiplyBy(INumber iNumber) {
        return iNumber.multiplyToInt(this);
    }
}