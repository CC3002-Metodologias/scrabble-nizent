package cl.uchile.dcc.scrabble.models.type;

/**
 * This interface represents the integer numbers that can be transformed to Binary or Int
 */
public interface IInteger extends INumber {

    /**
     * Transforms a Scrabble Integer to a Scrabble Binary
     * @return the equivalent Scrabble Binary object
     */
    ScrabbleBinary transformToScrabbleBinary();

    /**
     * Transforms a Scrabble Integer to a Scrabble Int object
     * @return the equivalent Scrabble Int object
     */
    ScrabbleInt transformToScrabbleInt();

    /**
     * Sum a Scrabble Binary object
     * @param scrabbleBinary the Scrabble Binary object
     * @return the INumber result by summing both objects
     */
    IInteger sumToBinary(ScrabbleBinary scrabbleBinary);

    /**
     * Subtracts to a ScrabbleBinary
     * @param scrabbleBinary the ScrabbleBinary object
     * @return a new IInteger containing the result
     */
    IInteger subtractToBinary(ScrabbleBinary scrabbleBinary);

    /**
     * Divides a ScrabbleBinary
     * @param scrabbleBinary the ScrabbleBinary object
     * @return a new IInteger containing the result
     */
    IInteger divideToBinary(ScrabbleBinary scrabbleBinary);

    /**
     * Multiplies a ScrabbleBinary
     * @param scrabbleBinary the ScrabbleBinary object
     * @return a new IInteger containing the result
     */
    IInteger multiplyToBinary(ScrabbleBinary scrabbleBinary);
}