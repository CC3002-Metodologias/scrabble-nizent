package cl.uchile.dcc.scrabble.models;

import java.util.Objects;

/**
 * Represents a Boolean an its behavior
 * @author Nicolás Zenteno Guardia
 */
public class ScrabbleBool extends AbstractScrabbleType {
    private boolean value;

    /**
     * Creates a new Scrabble Bool
     * @param value a boolean
     */
    public ScrabbleBool(boolean value) {
        this.value=value;
    }

    /**
     * Returns the hash code of the class
     * @return class hash code
     */
    @Override
    public int hashCode(){
        return Objects.hash(ScrabbleBool.class);
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
            return boolObject.Value()==this.Value();
        }
        return false;
    }

    /**
     * Transforms a Scrabble Bool into a Scrabble Bool
     * @return the same object
     */
    public ScrabbleBool transformToScrabbleBool(){
        return this;
    }

    /**
     * Returns the value of the Bool
     * @return boolean value
     */
    public boolean Value() {
        return this.value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object objectValue() {
        return this.value;
    }
}
