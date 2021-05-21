package cl.uchile.dcc.scrabble.models;

/**
 * Represents a real number in its standard form ( base 10 )
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
     * @param iNumber the INumber object
     * @return the INumber result by summing both objects
     */
    INumber sum(IStandard iNumber);

    INumber sum(IEncodedInteger iEncodedInteger);

    INumber subtractToFloat(ScrabbleFloat scrabbleFloat);

    INumber subtract(IStandard iNumber);

    INumber subtract(IEncodedInteger iEncodedInteger);

    INumber divideFloat(ScrabbleFloat scrabbleFloat);

    INumber divideBy(IStandard iStandard);

    INumber divideBy(IEncodedInteger iEncodedInteger);

    INumber multiplyFloat(ScrabbleFloat scrabbleFloat);

    INumber multiplyBy(IStandard iStandard);

    INumber multiplyBy(IEncodedInteger iEncodedInteger);
}
