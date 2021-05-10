package cl.uchile.dcc.scrabble.models;

/**
 * This interface represents the integer numbers that can be transformed to Binary or Int
 */
public interface IInteger<T> extends INumber<T> {
    /**
     * Transforms a Scrabble Integer to a Scrabble Binary
     * @return the equivalent Scrabble Binary object
     */
    ScrabbleBinary transformToScrabbleBinary();

    /**
     * Transforms a Scrable Integer to a Scrabble Int object
     * @return the equivalent Scrabble Int object
     */
    ScrabbleInt transformToScrabbleInt();
}
