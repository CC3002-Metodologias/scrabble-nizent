package cl.uchile.dcc.scrabble.models.type;

public interface IEncodedInteger extends IInteger {
    /**
     * Sum a IInteger object
     * @param iInteger the IInteger object
     * @return the IInteger result by summing both objects
     */
    IInteger sum(IInteger iInteger);

    /**
     * Subtracts an IInteger object
     * @param iInteger the IInteger object
     * @return an IInteger containing the result
     */
    IInteger subtract(IInteger iInteger);

    /**
     * Divides by an IInteger object
     * @param iInteger the IInteger number
     * @return an IInteger containing the result
     */
    IInteger divideBy(IInteger iInteger);

    /**
     * Multiplies by an IInteger number
     * @param iInteger the IInteger number
     * @return an IInteger containing the result
     */
    IInteger multiplyBy(IInteger iInteger);
}
