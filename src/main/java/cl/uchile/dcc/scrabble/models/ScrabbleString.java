package cl.uchile.dcc.scrabble.models;

import java.util.Objects;

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
     * @return
     */
    @Override
    public int hashCode(){
        return Objects.hash(ScrabbleString.class);
    }

    /**
     * Check if the string is equals to an object
     * @param object an object
     * @return true if it is compared with an Scrabble String with the same string
     */
    @Override
    public boolean equals(Object object){
        if(object instanceof ScrabbleString){
            var stringObject = (ScrabbleString) object;
            return stringObject.toString().equals(this.toString());
        }
        return false;
    }

    /**
     * Returns the value of the Scrabble String
     * @return value
     */
    @Override
    public Object Value(){
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
}
