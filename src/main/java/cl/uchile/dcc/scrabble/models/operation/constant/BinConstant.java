package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constantFactory.BinFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.FloatFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.IntFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.StringFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;

/**
 * Represents a BinConstant that contains a ScrabbleBinary value
 */
public class BinConstant extends AbstractConstant {
    private final ScrabbleBinary value;

    /**
     * Creates a new BinConstant with a ScrabbleBinary value
     * @param value the ScrabbleBinary
     */
    public BinConstant(ScrabbleBinary value) {
        this.value = value;
    }

    /**
     * Gets the value.
     * Creates a new value, so the real value can't be changed
     * @return a copy of value
     */
    public ScrabbleBinary value() {
        return new ScrabbleBinary(this.value.value());
    }

    /**
     * Checks if other object is equal to the constant
     * @param obj the object
     * @return true if they are equal
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof BinConstant){
            BinConstant binConstant = (BinConstant) obj;
            return binConstant.value().equals(this.value);
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
     * Makes an addition with a BinConstant
     * @param binConstant the BinConstant
     * @return the result of addition
     */
    @Override
    public Constant addToBin(BinConstant binConstant){
        return BinFactory.getConstant(binConstant.value().
                sum(this.value).transformToScrabbleBinary());
    }

    /**
     * Concatenates the constant to a StringConstant
     * @param stringConstant the StringConstant
     * @return the StringConstant concatenated to this constant
     */
    @Override
    public Constant addToString(StringConstant stringConstant){
        return StringFactory.getConstant(stringConstant.value().sum(this.value));
    }

    /**
     * Makes an addition with another constant
     * @param constant the other constant
     * @return the result of addition with the constant
     */
    @Override
    public Constant add(Constant constant){
        return constant.addToBin(this);
    }

    /**
     * Subtracts to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of subtraction
     */
    @Override
    public Constant subToBin(BinConstant binConstant){
        return BinFactory.getConstant(binConstant.value().
                subtract(this.value).transformToScrabbleBinary());
    }

    /**
     * Subtracts the constant by another constant
     * @param constant the other constant
     * @return a constant containing the subtraction
     */
    @Override
    public Constant sub(Constant constant){
        return constant.subToBin(this);
    }

    /**
     * Multiplies to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of multiplication
     */
    @Override
    public Constant multToBin(BinConstant binConstant){
        return BinFactory.getConstant(binConstant.value().
                multiplyBy(this.value).transformToScrabbleBinary());
    }

    /**
     * Multiplies the constant by another constant
     * @param constant the other constant
     * @return a constant containing the result
     */
    @Override
    public Constant mult(Constant constant){
        return constant.multToBin(this);
    }

    /**
     * Divides a BinConstant
     * @param binConstant the BinConstant
     * @return the result of division
     */
    @Override
    public Constant divToBin(BinConstant binConstant){
        return BinFactory.getConstant(binConstant.value().
                divideBy(this.value).transformToScrabbleBinary());
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
        return FloatFactory.getConstant(this.value.sumToFloat(floatConstant.value()).transformToScrabbleFloat());
    }

    /**
     * Subtraction to a FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of subtraction
     */
    @Override
    public Constant subToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.subtractToFloat(floatConstant.value()).transformToScrabbleFloat());
    }

    /**
     * Multiplies to a FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of multiplication
     */
    @Override
    public Constant multToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.multiplyToFloat(floatConstant.value()).transformToScrabbleFloat());
    }

    /**
     * Divides to a FloatConstant
     * @param floatConstant the FloatConstant
     * @return the result of division
     */
    @Override
    public Constant divToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.divideToFloat(floatConstant.value()).transformToScrabbleFloat());
    }

    /**
     * Divides the constant by another constant
     * @param constant the other constant
     * @return a constant containing the division result
     */
    @Override
    public Constant div(Constant constant){
        return constant.divToBin(this);
    }

    /**
     * Makes an and to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of and operation
     */
    @Override
    public Constant andToBin(BinConstant binConstant){
        return BinFactory.getConstant(binConstant.value().
                andBinary(this.value));
    }

    /**
     * Makes an and to a BoolConstant
     * @param boolConstant the BoolConstant
     * @return the result of and operation
     */
    @Override
    public Constant andToBool(BoolConstant boolConstant){
        return BinFactory.getConstant(this.value.andBool(boolConstant.value()));
    }

    /**
     * Makes a logical and operation with other constant
     * @param constant the other constant
     * @return a constant containing the and result
     */
    @Override
    public Constant and(Constant constant){
        return constant.andToBin(this);
    }

    /**
     * Makes an or to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of or operation
     */
    @Override
    public Constant orToBin(BinConstant binConstant){
        return BinFactory.getConstant(binConstant.value().
                orBinary(this.value));
    }

    /**
     * Makes an or to a BoolConstant
     * @param boolConstant the BoolConstant
     * @return the result of or operation
     */
    @Override
    public Constant orToBool(BoolConstant boolConstant){
        return BinFactory.getConstant(this.value.orBool(boolConstant.value()));
    }

    /**
     * Makes a logical or operation with other constant
     * @param constant the other constant
     * @return a constant containing the and result
     */
    @Override
    public Constant or(Constant constant){
        return constant.orToBin(this);
    }

    /**
     * Makes a logical negation operation to the constant
     * @return a constant containing the and result
     */
    @Override
    public Constant negate(){
        // evade overloading with creating a new scrabble binary, negate returns ILogic
        return BinFactory.getConstant(new ScrabbleBinary(this.value.negatedString()));
    }

    /**
     * Gets the String representation of the constant
     * @return a String that represents the constant
     */
    @Override
    public String toString(){
        return "SBin(" +this.value.toString()+ ")";
    }
}