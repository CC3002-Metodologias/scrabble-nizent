package cl.uchile.dcc.scrabble.models;

/**
 * this interface represents real numbers, encoded or not, that can be operated with each other
 * @author Nicolás Zenteno Guardia
 */
public interface INumber extends IType{
    /**
     * transforms a Scrabble number to a Scrabble Float
     * @return the equivalent Scrabble Float
     */
    ScrabbleFloat transformToScrabbleFloat();

    /**
     * Sum a Scrabble Int object
     * @param scrabbleInt the Scrabble Int object
     * @return the INumber result by summing both objects
     */
    INumber sumInt(ScrabbleInt scrabbleInt);

    INumber subtractToInt(ScrabbleInt scrabbleInt);

    INumber divideToInt(ScrabbleInt scrabbleInt);

    INumber multiplyInt(ScrabbleInt scrabbleInt);

}
