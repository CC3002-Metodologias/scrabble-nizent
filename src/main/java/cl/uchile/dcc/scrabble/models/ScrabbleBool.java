package cl.uchile.dcc.scrabble.models;

/**
 * Represents a Boolean an its behavior
 * @author Nicolás Zenteno Guardia
 */
public class ScrabbleBool extends AbstractScrabbleType implements ILogic{
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
            return boolObject.Value()==this.value;
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
    @Override
    public Boolean Value() {
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
    public String toString(){
        return Boolean.valueOf(this.value).toString();
    }

    @Override
    public ILogic andBinary(ScrabbleBinary scrabbleBinary) {
        return scrabbleBinary.andBool(this);
    }

    @Override
    public ILogic andBool(ScrabbleBool scrabbleBool) {
        return new ScrabbleBool(scrabbleBool.Value() & this.value);
    }

    @Override
    public ILogic and(ILogic iLogic) {
        return iLogic.andBool(this);
    }

    @Override
    public ILogic orBinary(ScrabbleBinary scrabbleBinary) {
        return scrabbleBinary.orBool(this);
    }

    @Override
    public ILogic orBool(ScrabbleBool scrabbleBool) {
        return new ScrabbleBool(this.value | scrabbleBool.Value());
    }

    @Override
    public ILogic or(ILogic iLogic) {
        return iLogic.orBool(this);
    }
}