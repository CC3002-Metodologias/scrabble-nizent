package cl.uchile.dcc.scrabble.models.type;

/**
 * this interface represents real numbers, encoded or not, that can be operated each other
 * @author Nicolás Zenteno Guardia
 */
public interface INumber extends IType {
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
    IStandard sumToInt(ScrabbleInt scrabbleInt);

    /**
     * Subtracts to a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return an INumber containing the subtraction result
     */
    IStandard subtractToInt(ScrabbleInt scrabbleInt);

    /**
     * Divides a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return an INumber containing the division result
     */
    IStandard divideToInt(ScrabbleInt scrabbleInt);

    /**
     * Multiplies a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return an INumber containing the multiplication result
     */
    IStandard multiplyToInt(ScrabbleInt scrabbleInt);

    /**
     * Sum a Scrabble Float object
     * @param scrabbleFloat the Scrabble Float object
     * @return the INumber result by summing both objects
     */
    ScrabbleFloat sumToFloat(ScrabbleFloat scrabbleFloat);

    /**
     * Subtracts to a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new INumber containing the result
     */
    ScrabbleFloat subtractToFloat(ScrabbleFloat scrabbleFloat);

    /**
     * Divides a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new INumber containing the division result between values
     */
    ScrabbleFloat divideToFloat(ScrabbleFloat scrabbleFloat);

    /**
     * Multiplies a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new INumber containing the multiplication of its values
     */
    ScrabbleFloat multiplyToFloat(ScrabbleFloat scrabbleFloat);
}
