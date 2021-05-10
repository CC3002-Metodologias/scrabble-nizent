package cl.uchile.dcc.scrabble.models;

import java.util.Objects;

/**
 * Represents an String and its behavior
 * @author Nicolás Zenteno Guardia
 */
public class ScrabbleString extends AbstractScrabbleType<String> {

    /**
     * Creates a new Scrabble String
     * @param value String value
     */
    public ScrabbleString(String value) {
        super(value);
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
            return stringObject.Value().equals(this.Value());
        }
        return false;
    }
}
