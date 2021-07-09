package cl.uchile.dcc.scrabble.models.type;

/**
 *
 * Represents a real number in its standard form
 * For example, 12.345 , 14
 *
 */
public interface IStandard extends INumber {

    /**
     * Sums a INumber object
     * @param iNumber the INumber object
     * @return the INumber result by summing both objects
     */
    IStandard sum(INumber iNumber);

    /**
     * Subtracts an INumber number
     * @param iNumber the INumber number
     * @return an INumber containing the result
     */
    IStandard subtract(INumber iNumber);

    /**
     * Divides by an INumber number
     * @param iNumber the INumber object
     * @return a new INumber containing the result of division
     */
    IStandard divideBy(INumber iNumber);

    /**
     * Multiplies an INumber number
     * @param iNumber the INumber object
     * @return a new INumber containing the result
     */
    IStandard multiplyBy(INumber iNumber);
}