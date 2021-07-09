package cl.uchile.dcc.scrabble.models.type;

/**
 * Represents an String and its behavior
 * @author Nicolás Zenteno Guardia
 */
public class ScrabbleString extends AbstractScrabbleType {
    private String value;

    /**
     * Creates a new Scrabble String
     * @param value String value
     */
    public ScrabbleString(String value) {
        this.value=value;
    }

    /**
     * Returns the hash code of the class
     * @return int hashcode
     */
    @Override
    public int hashCode(){
        return this.value.hashCode();
    }

    /**
     * Check if the string is equals to an object
     * @param object an object
     * @return true if it is compared with an Scrabble String with the same string
     */
    @Override
    public boolean equals(Object object){
        if(object instanceof ScrabbleString){
            ScrabbleString stringObject = (ScrabbleString) object;
            return stringObject.value().equals(this.value);
        }
        return false;
    }

    /**
     * Returns the value of the Scrabble String
     * @return value
     */
    public String value(){
        return this.value;
    }

    /**
     * @inheritDoc
     */
    @Override
    public ScrabbleString transformToScrabbleString() {
        return new ScrabbleString(this.value);
    }

    /**
     * Set value of Scrabble String
     * @param value string
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Transform the value of the ScrabbleType to an String
     * @return the String containing the value
     */
    @Override
    public String toString(){
        return this.value;
    }

    /**
     * Adds the value of a type to the string value of the caller
     * @param iType object to add
     * @return a new Scrabble String containing the concatenated string
     */
    public ScrabbleString sum(IType iType){
        return new ScrabbleString(this.value + iType.toString());
    }
}