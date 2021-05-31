package cl.uchile.dcc.scrabble.models;

/**
 * this interface represents real numbers, encoded or not, that can be operated each other
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
     * @return the INumber result by summing both object values
     */
    INumber sumToInt(ScrabbleInt scrabbleInt);

    /**
     * Subtracts to a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return an INumber containing the subtraction result
     */
    INumber subtractToInt(ScrabbleInt scrabbleInt);

    /**
     * Divides a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return an INumber containing the division result
     */
    INumber divideToInt(ScrabbleInt scrabbleInt);

    /**
     * Multiplies a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return an INumber containing the multiplication result
     */
    INumber multiplyToInt(ScrabbleInt scrabbleInt);

    /**
     * Sum a Scrabble Float object
     * @param scrabbleFloat the Scrabble Float object
     * @return the INumber result by summing both objects
     */
    INumber sumToFloat(ScrabbleFloat scrabbleFloat);

    /**
     * Subtracts to a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new INumber containing the result
     */
    INumber subtractToFloat(ScrabbleFloat scrabbleFloat);

    /**
     * Divides a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new INumber containing the division result between values
     */
    INumber divideToFloat(ScrabbleFloat scrabbleFloat);

    /**
     * Multiplies a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new INumber containing the multiplication of its values
     */
    INumber multiplyToFloat(ScrabbleFloat scrabbleFloat);
}
