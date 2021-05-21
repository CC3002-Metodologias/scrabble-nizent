package cl.uchile.dcc.scrabble.models;

public interface IEncodedInteger extends IInteger{
    /**
     * Sum a INumber object
     * @param iInteger the INumber object
     * @return the INumber result by summing both objects
     */
    IInteger sum(IInteger iInteger);

    IInteger subtract(IInteger iInteger);

    IInteger divideBy(IInteger iInteger);

    IInteger multiplyBy(IInteger iInteger);
}
