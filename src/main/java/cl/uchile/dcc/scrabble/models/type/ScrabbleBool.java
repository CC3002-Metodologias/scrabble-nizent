package cl.uchile.dcc.scrabble.models.type;

/**
 * Represents a Boolean an its behavior
 * @author Nicolás Zenteno Guardia
 */
public class ScrabbleBool extends AbstractScrabbleType implements ILogic, NotNumber {
    private boolean value;

    /**
     * Creates a new Scrabble Bool
     * @param value a boolean
     */
    public ScrabbleBool(boolean value) {
        this.value = value;
    }

    /**
     * Returns the hash code of the class
     * @return class hash code
     */
    @Override
    public int hashCode(){
        return Boolean.hashCode(this.value);
    }

    /**
     * Check if other object is a Scrabble Bool and if its value is the same
     * @param object another object
     * @return true if the object is a Scrabble Bool and its value if the same, false in any other case
     */
    @Override
    public boolean equals(Object object){
        if(object instanceof ScrabbleBool){
            var boolObject = (ScrabbleBool) object;
            return boolObject.value()==this.value;
        }
        return false;
    }

    /**
     * Transforms a Scrabble Bool into a Scrabble Bool
     * @return the same object
     */
    public ScrabbleBool transformToScrabbleBool(){
        return new ScrabbleBool(this.value);
    }

    /**
     * Returns the value of the Scrabble Bool
     * @return value
     */
    public boolean value() {
        return this.value;
    }

    /**
     * Set value of Scrabble Boolean
     * @param value boolean
     */
    public void setValue(boolean value) {
        this.value = value;
    }

    /**
     * Transforms the object into a ScrabbleString object
     * @return a new ScrabbleString object containing a String equivalent to the object value
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
    public String toString(){
        return Boolean.valueOf(this.value).toString();
    }

    /**
     * Makes a logical and operation with a ScrabbleBinary object
     * @param scrabbleBinary the ScrabbleBinary object
     * @return a new ScrabbleBinary containing the result
     */
    @Override
    public ScrabbleBinary andBinary(ScrabbleBinary scrabbleBinary) {
        return scrabbleBinary.andBool(this);
    }

    /**
     * Makes a logical and operation with an ScrabbleBool object
     * @param scrabbleBool the ScrabbleBool object
     * @return a new ScrabbleBool containing the operation result
     */
    @Override
    public ScrabbleBool andBool(ScrabbleBool scrabbleBool) {
        return new ScrabbleBool(scrabbleBool.value() & this.value);
    }

    /**
     * Makes a logical and operation with an ILogic object
     * @param iLogic the ILogic object
     * @return a new ILogic object containing the result
     */
    @Override
    public ILogic and(ILogic iLogic) {
        return iLogic.andBool(this);
    }

    /**
     * Makes a logical or operation with a ScrabbleBinary object
     * @param scrabbleBinary the ScrabbleBinary object
     * @return an ILogic object containing the result value
     */
    @Override
    public ScrabbleBinary orBinary(ScrabbleBinary scrabbleBinary) {
        return scrabbleBinary.orBool(this);
    }

    /**
     * Makes a logical or operation with a ScrabbleBool object
     * @param scrabbleBool the ScrabbleBool object
     * @return a new ScrabbleBool with the result of the operation
     */
    @Override
    public ScrabbleBool orBool(ScrabbleBool scrabbleBool) {
        return new ScrabbleBool(this.value | scrabbleBool.value());
    }

    /**
     * Makes a logical or operation with an ILogic object
     * @param iLogic the ILogic object
     * @return a new ILogic object with the result
     */
    @Override
    public ILogic or(ILogic iLogic) {
        return iLogic.orBool(this);
    }

    /**
     * Makes a negation operation to the object
     * @return a new SrabbleBool with the result of the negation
     */
    @Override
    public ScrabbleBool negate() {
        return new ScrabbleBool(!this.value);
    }
}