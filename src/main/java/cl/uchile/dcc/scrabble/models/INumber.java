package cl.uchile.dcc.scrabble.models;

/**
 * this interface represents real numbers, encoded or not, that can be operated with each other
 */
public interface INumber extends IType{
    /**
     * transforms a Scrabble number to a Scrabble Float
     * @return the equivalent Scrabble Float
     */
    ScrabbleFloat transformToScrabbleFloat();
}
