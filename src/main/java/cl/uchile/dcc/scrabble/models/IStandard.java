package cl.uchile.dcc.scrabble.models;

/**
 * Represents a real number in its standard form
 */
public interface IStandard extends INumber {
    /**
     * Sum a Scrabble Float object
     * @param scrabbleFloat the Scrabble Float object
     * @return the INumber result by summing both objects
     */
    INumber sumFloat(ScrabbleFloat scrabbleFloat);

    /**
     * Sum a INumber object
     * @param iStandardNumber the IStandard object
     * @return the INumber result by summing both objects
     */
    INumber sum(IStandard iStandardNumber);

    /**
     * Sums an IEncodedInteger
     * @param iEncodedInteger the IEncodedInteger object
     * @return a new INumber containing the sum of its values
     */
    INumber sum(IEncodedInteger iEncodedInteger);

    /**
     * Subtracts to a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new INumber containing the result
     */
    INumber subtractToFloat(ScrabbleFloat scrabbleFloat);

    /**
     * Subtracts an IStandard number
     * @param iStandard the IStandard number
     * @return an INumber containing the result
     */
    INumber subtract(IStandard iStandard);

    /**
     * Subtracts an IEncodedInteger
     * @param iEncodedInteger the IEncodedInteger object
     * @return a new INumber containing the subtraction result
     */
    INumber subtract(IEncodedInteger iEncodedInteger);


    /**
     * Divides a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new INumber containing the division result between values
     */
    INumber divideFloat(ScrabbleFloat scrabbleFloat);

    /**
     * Divides the ScrabbleFloat by an IStandard number
     * @param iStandard the IStandard object
     * @return a new INumber containing the result of division
     */
    INumber divideBy(IStandard iStandard);

    /**
     * Divides by an IEncodedInteger number
     * @param iEncodedInteger the IEncodedInteger object
     * @return a new INumber containing the division result
     */
    INumber divideBy(IEncodedInteger iEncodedInteger);

    /**
     * Multiplies a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new INumber containing the multiplication of its values
     */
    INumber multiplyFloat(ScrabbleFloat scrabbleFloat);

    /**
     * Multiplies an IStandard number
     * @param iStandard the IStandard object
     * @return a new INumber containing the result
     */
    INumber multiplyBy(IStandard iStandard);

    /**
     * Multiplies an IEncodedInteger
     * @param iEncodedInteger the IEncodedInteger object
     * @return a new INumber number containing the multiplication between its values
     */
    INumber multiplyBy(IEncodedInteger iEncodedInteger);
}
