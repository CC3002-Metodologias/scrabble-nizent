package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constantFactory.BinFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.BoolFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.StringFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBool;

/**
 * Represents a BoolConstant that contains a ScrabbleBool
 */
public class BoolConstant extends AbstractConstant {
    private final ScrabbleBool value;

    /**
     * Creates a new BoolConstant that contains a ScrabbleBool value
     * @param value the value
     */
    public BoolConstant(ScrabbleBool value){
        this.value = value;
    }

    /**
     * Gets the value
     * Creates a new value, so the real value can't be changed
     * @return a copy of value
     */
    public ScrabbleBool value() {
        return new ScrabbleBool(this.value.value());
    }

    /**
     * Checks if other object is equal to the constant
     * @param obj the object
     * @return true if they are equal
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof BoolConstant){
            BoolConstant boolConstant = (BoolConstant) obj;
            return boolConstant.value().equals(this.value);
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
     * Makes an and to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of and operation
     */
    @Override
    public Constant andToBin(BinConstant binConstant) {
        return BinFactory.getConstant(this.value.andBinary(binConstant.value()));
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
     * Makes an or to a BinConstant
     * @param binConstant the BinConstant
     * @return the result of or operation
     */
    @Override
    public Constant orToBin(BinConstant binConstant) {
        return BinFactory.getConstant(this.value.orBinary(binConstant.value()));
    }

    /**
     * Makes an or to a BoolConstant
     * @param boolConstant the BoolConstant
     * @return the result of or operation
     */
    @Override
    public Constant orToBool(BoolConstant boolConstant) {
        return BoolFactory.getConstant(this.value.orBool(boolConstant.value()));
    }


    /**
     * Makes an and to a BoolConstant
     * @param boolConstant the BoolConstant
     * @return the result of and operation
     */
    @Override
    public Constant andToBool(BoolConstant boolConstant) {
        return BoolFactory.getConstant(this.value.andBool(boolConstant.value()));
    }

    /**
     * Makes a logical and operation with other constant
     * @param constant the other constant
     * @return a constant containing the and result
     */
    @Override
    public Constant and(Constant constant){
        return constant.andToBool(this);
    }

    /**
     * Makes a logical or operation with other constant
     * @param constant the other constant
     * @return a constant containing the and result
     */
    @Override
    public Constant or(Constant constant){
        return constant.orToBool(this);
    }

    /**
     * Makes a logical negation operation to the constant
     * @return a constant containing the and result
     */
    @Override
    public Constant negate(){
        return BoolFactory.getConstant(this.value.negate());
    }

    /**
     * Gets the String representation of the constant
     * @return a String that represents the constant
     */
    @Override
    public String toString(){
        return "SBool(" +this.value.toString()+ ")";
    }
}
