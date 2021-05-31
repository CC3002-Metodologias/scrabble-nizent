package cl.uchile.dcc.scrabble.models;
import java.util.Objects;

/**
 * Represents a float number and its behavior
 * @author Nicolás Zenteno Guardia
 */
public class ScrabbleFloat extends AbstractNumber implements IStandard {
    private double value;

    /**
     * Creates a new Scrabble Float
     * @param value the double value of the Scrabble Float object
     */
    public ScrabbleFloat(double value) {
        this.value=value;
    }

    /**
     * Returns the class hash code
     * @return class hash code
     */
    @Override
    public int hashCode(){
        return Objects.hash(this.value);
    }

    /**
     * Transforms the ScrabbleFloat into a ScrabbleFloat
     * @return a new equivalent ScrabbleFloat
     */
    public ScrabbleFloat transformToScrabbleFloat(){
        return new ScrabbleFloat(this.value);
    }

    /**
     * Returns the value of the Scrabble Float
     * @return value
     */
    public double Value(){
        return this.value;
    }

    /**
     * Set value of ScrabbleFloat
     * @param value double
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Transforms the ScrabbleFloat into a ScrabbleString
     * @return a new ScrabbleString equivalent to the ScrabbleFloat
     */
    @Override
    public ScrabbleString transformToScrabbleString() {
        return new ScrabbleString(this.toString());
    }

    /**
     * Transform the value of the ScrabbleType to an String
     * @return the String containing the value
     */
    @Override
    public String toString() {
        return Double.valueOf(this.value).toString();
    }

    /**
     * Sums a ScrabbleInt.
     * Makes the sum between the value and the ScrabbleInt value
     * @param scrabbleInt the Scrabble Int object
     * @return a new ScrabbleFloat
     */
    @Override
    public INumber sumToInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleFloat(this.value+scrabbleInt.Value());
    }

    /**
     * Subtracts to a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return a ScrabbleFloat containing scrabbleInt value minus the ScrabbleFloat value
     */
    @Override
    public INumber subtractToInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleFloat(scrabbleInt.Value()-this.value);
    }

    /**
     * Divides a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return a new ScrabbleFloat containing ScrabbleInt value divided by the ScrabbleFloat value
     */
    @Override
    public INumber divideToInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleFloat(scrabbleInt.Value()/this.value);
    }

    /**
     * Multiplies a ScrabbleInt
     * @param scrabbleInt
     *      the ScrabbleInt object
     * @return
     *      a new ScrabbleFloat containing the multiplication between the ScrabbleInt value and
     *      the ScrabbleFloat value
     */
    @Override
    public INumber multiplyToInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleFloat(scrabbleInt.Value()*this.value);
    }

    /**
     * Sums a ScrabbleFloat
     * @param scrabbleFloat the Scrabble Float object
     * @return
     *      a new ScrabbleFloat containing the sum between value and
     *      the ScrabbleFloat input value
     */
    @Override
    public INumber sumToFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(this.value+scrabbleFloat.Value());
    }

    /**
     * Sums an IStandard number
     * @param iNumber the IStandard object
     * @return an IStandard number containing the sum
     */
    @Override
    public INumber sum(INumber iNumber) {
        return iNumber.sumToFloat(this);
    }

    /**
     * Subtracts to a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return
     *      a new ScrabbleFloat containing the result of
     *      input value minus the ScrabbleFloat value
     */
    @Override
    public INumber subtractToFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()-this.value);
    }

    /**
     * Subtracts an IStandard number
     * @param iNumber the IStandard number
     * @return an INumber containing the result of the ScrabbleFloat value minus input value
     */
    @Override
    public INumber subtract(INumber iNumber) {
        return iNumber.subtractToFloat(this);
    }

    /**
     * Divides a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return
     *      a new ScrabbleFloat containing the result of ScrabbleFloat input value divided by
     *      the ScrabbleFloat value
     */
    @Override
    public INumber divideToFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()/this.value);
    }

    /**
     * Divides the ScrabbleFloat by an IStandard number
     * @param iNumber the IStandard object
     * @return a new INumber containing the result of division
     */
    @Override
    public INumber divideBy(INumber iNumber) {
        return iNumber.divideToFloat(this);
    }

    /**
     * Multiplies a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new ScrabbleFloat containing the multiplication of its values
     */
    @Override
    public INumber multiplyToFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()*this.value);
    }

    /**
     * Multiplies an IStandard number
     * @param iNumber the IStandard object
     * @return a new INumber containing the result
     */
    @Override
    public INumber multiplyBy(INumber iNumber) {
        return iNumber.multiplyToFloat(this);
    }

}
