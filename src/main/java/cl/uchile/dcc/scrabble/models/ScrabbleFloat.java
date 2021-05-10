package cl.uchile.dcc.scrabble.models;

import java.util.Objects;

/**
 * Represents a float number and its behavior
 */
public class ScrabbleFloat extends AbstractNumber<Double> {

    /**
     * Creates a new Scrabble Float
     * @param value the double value of the Scrabble Float object
     */
    public ScrabbleFloat(double value) {
        super(value);
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

}
