package cl.uchile.dcc.scrabble.models;

import java.util.Objects;

/**
 * Represents a float number and its behavior
 * @author Nicolás Zenteno Guardia
 */
public class ScrabbleFloat extends AbstractNumber {
    private double value;

    /**
     * Creates a new Scrabble Float
     * @param value the double value of the Scrabble Float object
     */
    public ScrabbleFloat(double value) {
        this.value=value;
    }

    /**
     * Returns the class hash code
     * @return class hash code
     */
    @Override
    public int hashCode(){
        return Objects.hash(ScrabbleFloat.class);
    }

    /**
     * {@inheritDoc}
     */
    public ScrabbleFloat transformToScrabbleFloat(){
        return this;
    }

    /**
     * Returns the value of the Scrabble Float
     * @return value
     */
    @Override
    public Object Value(){
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
