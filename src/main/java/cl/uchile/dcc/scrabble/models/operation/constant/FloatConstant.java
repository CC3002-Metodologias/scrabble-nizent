package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constantFactory.FloatFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.StringFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;

/**
 * Represents a float constant, that contains a ScrabbleFloat value
 */
public class FloatConstant extends AbstractConstant{
    private final ScrabbleFloat value;

    /**
     * Creates a new FloatConstant that contains a ScrabbleFloat value
     * @param value the value
     */
    public FloatConstant(ScrabbleFloat value){
        this.value = value;
    }

    /**
     * Gets the value
     * Creates a new value, so the real value can't be changed
     * @return a copy of value
     */
    public ScrabbleFloat value(){
        return new ScrabbleFloat(this.value.value());
    }

    /**
     * Checks if other object is equal to the constant
     * @param obj the object
     * @return true if they are equal
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof FloatConstant){
            FloatConstant floatConstant = (FloatConstant) obj;
            return floatConstant.value().equals(this.value);
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
        return constant.addToFloat(this);
    }

    /**
     * Divides the constant by another constant
     * @param evaluate the other constant
     * @return a constant containing the division result
     */
    @Override
    public Constant div(Constant evaluate) {
        return evaluate.divToFloat(this);
    }

    /**
     * Multiplies the constant by another constant
     * @param evaluate the other constant
     * @return a constant containing the multiplication
     */
    @Override
    public Constant mult(Constant evaluate) {
        return evaluate.multToFloat(this);
    }

    /**
     * Subtracts the constant by another constant
     * @param evaluate the other constant
     * @return a constant containing the subtraction
     */
    @Override
    public Constant sub(Constant evaluate) {
        return evaluate.subToFloat(this);
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
     * Makes an addition with an IntConstant
     * @param intConstant the IntConstant
     * @return the result of addition
     */
    @Override
    public Constant addToInt(IntConstant intConstant) {
        return FloatFactory.getConstant(this.value.sumToInt(intConstant.value()));
    }

    /**
     * Subtracts to an IntConstant
     * @param intConstant the IntConstant
     * @return the result of subtraction
     */
    @Override
    public Constant subToInt(IntConstant intConstant) {
        return FloatFactory.getConstant(this.value.subtractToInt(intConstant.value()));
    }

    /**
     * Multiplies to an IntConstant
     * @param intConstant the IntConstant
     * @return the result of multiplication
     */
    @Override
    public Constant multToInt(IntConstant intConstant) {
        return FloatFactory.getConstant(this.value.multiplyToInt(intConstant.value()));
    }


    /**
     * Divides to an IntConstant
     * @param intConstant the IntConstant
     * @return the result of division
     */
    @Override
    public Constant divToInt(IntConstant intConstant) {
        return FloatFactory.getConstant(this.value.divideToInt(intConstant.value()));
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
        return "SFloat(" +this.value.toString()+ ")";
    }
}