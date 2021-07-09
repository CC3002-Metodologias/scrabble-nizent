package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constantFactory.StringFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleString;

/**
 * Represents a StringConstant that contains a ScrabbleString value
 */
public class StringConstant extends AbstractConstant{
    private final ScrabbleString value;

    /**
     * Creates a new StringConstant that contains a ScrabbleString value
     * @param value the value
     */
    public StringConstant(ScrabbleString value) {
        this.value = value;
    }

    /**
     * Gets the value
     * Creates a new value, so the real value can't be changed
     * @return a copy of value
     */
    public ScrabbleString value(){
        return new ScrabbleString(this.value.value());
    }

    /**
     * Checks if other object is equal to the constant
     * @param obj the object
     * @return true if they are equal
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof StringConstant){
            StringConstant stringConstant = (StringConstant) obj;
            return stringConstant.value().equals(this.value);
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
     * Makes a concatenation with another constant
     * @param constant the other constant
     * @return the result concatenation constant
     */
    @Override
    public Constant add(Constant constant) {
        return constant.addToString(this);
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
     * Gets the String representation of the constant
     * @return a String that represents the constant
     */
    @Override
    public String toString(){
        return "SString(" +this.value.toString()+ ")";
    }
}