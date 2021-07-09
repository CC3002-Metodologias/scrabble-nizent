package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constantFactory.BinFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.FloatFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.IntFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.StringFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;

/**
 * Represents an IntConstant that contains a ScrabbleInt value
 */
public class IntConstant extends AbstractConstant{
    private final ScrabbleInt value;

    /**
     * Creates a new IntConstant that contains a ScrabbleInt value
     * @param value the value
     */
    public IntConstant(ScrabbleInt value){
        this.value = value;
    }

    /**
     * Gets the value
     * Creates a new value, so the real value can't be changed
     * @return a copy of value
     */
    public ScrabbleInt value(){
        return new ScrabbleInt(this.value.value());
    }

    /**
     * Checks if other object is equal to the constant
     * @param obj the object
     * @return true if they are equal
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof IntConstant){
            IntConstant intConstant = (IntConstant) obj;
            return intConstant.value().equals(this.value);
        }
        return false;
    }

    /**
     * Gets the hashCode of the constant
     * @return the hash code
     */
    @Override
    public int hashCode(){
        return this.value.hashCode();
    }

    /**
     * Makes an addition with another constant
     * @param constant the other constant
     * @return the result of addition with the constant
     */
    @Override
    public Constant add(Constant constant) {
        return constant.addToInt(this);
    }

    /**
     * Divides the constant by another constant
     * @param evaluate the other constant
     * @return a constant containing the division result
     */
    @Override
    public Constant div(Constant evaluate) {
        return evaluate.divToInt(this);
    }

    /**
     * Multiplies the constant by another constant
     * @param evaluate the other constant
     * @return a constant containing the multiplication
     */
    @Override
    public Constant mult(Constant evaluate) {
        return evaluate.multToInt(this);
    }

    /**
     * Subtracts the constant by another constant
     * @param evaluate the other constant
     * @return a constant containing the subtraction
     */
    @Override
    public Constant sub(Constant evaluate) {
        return evaluate.subToInt(this);
    }

    /**
     * Concatenates the constant to a StringConstant
     * @param stringConstant the StringConstant
     * @return the StringConstant concatenated to this constant
     */
    @Override
    public Constant addToString(StringConstant stringConstant) {
        return StringFactory.getConstant(stringConstant.value().sum(this.value));
    }
    /**
     * Makes an addition with a BinConstant
     * @param binConstant the BinConstant
     * @return the result of addition
     */
    @Override
    public Constant addToBin(BinConstant binConstant) {
        return BinFactory.getConstant(binConstant.value().sum(this.value).transformToScrabbleBinary());
    }

    /**
     * Subtracts to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of subtraction
     */
    @Override
    public Constant subToBin(BinConstant binConstant) {
        return BinFactory.getConstant(binConstant.value().subtract(this.value).transformToScrabbleBinary());
    }

    /**
     * Multiplies to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of multiplication
     */
    @Override
    public Constant multToBin(BinConstant binConstant) {
        return BinFactory.getConstant(binConstant.value().multiplyBy(this.value).transformToScrabbleBinary());
    }


    /**
     * Divides a BinConstant
     * @param binConstant the BinConstant
     * @return the result of division
     */
    @Override
    public Constant divToBin(BinConstant binConstant) {
        return BinFactory.getConstant(binConstant.value().divideBy(this.value).transformToScrabbleBinary());
    }

    /**
     * Makes an addition with an IntConstant
     * @param intConstant the IntConstant
     * @return the result of addition
     */
    @Override
    public Constant addToInt(IntConstant intConstant) {
        return IntFactory.getConstant(this.value.sumToInt(intConstant.value()));
    }

    /**
     * Subtracts to an IntConstant
     * @param intConstant the IntConstant
     * @return the result of subtraction
     */
    @Override
    public Constant subToInt(IntConstant intConstant) {
        return IntFactory.getConstant(this.value.subtractToInt(intConstant.value()));
    }

    /**
     * Multiplies to an IntConstant
     * @param intConstant the IntConstant
     * @return the result of multiplication
     */
    @Override
    public Constant multToInt(IntConstant intConstant) {
        return IntFactory.getConstant(this.value.multiplyToInt(intConstant.value()));
    }

    /**
     * Divides to an IntConstant
     * @param intConstant the IntConstant
     * @return the result of division
     */
    @Override
    public Constant divToInt(IntConstant intConstant) {
        return IntFactory.getConstant(this.value.divideToInt(intConstant.value()));
    }

    /**
     * Adds to a FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of addition
     */
    @Override
    public Constant addToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.sumToFloat(floatConstant.value()));
    }


    /**
     * Subtraction to a FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of subtraction
     */
    @Override
    public Constant subToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.subtractToFloat(floatConstant.value()));
    }

    /**
     * Multiplies to a FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of multiplication
     */
    @Override
    public Constant multToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.multiplyToFloat(floatConstant.value()));
    }

    /**
     * Divides to a FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of division
     */
    @Override
    public Constant divToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.divideToFloat(floatConstant.value()));
    }

    /**
     * Gets the String representation of the constant
     * @return a String that represents the constant
     */
    @Override
    public String toString(){
        return "SInt(" +this.value.toString()+ ")";
    }
}