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
    public INumber sumInt(ScrabbleInt scrabbleInt) {
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
    public INumber multiplyInt(ScrabbleInt scrabbleInt) {
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
    public INumber sumFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(this.value+scrabbleFloat.Value());
    }

    /**
     * Sums an IStandard number
     * @param iStandardNumber the IStandard object
     * @return an IStandard number containing the sum
     */
    @Override
    public INumber sum(IStandard iStandardNumber) {
        return iStandardNumber.sumFloat(this);
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
     * @param iStandard the IStandard number
     * @return an INumber containing the result of the ScrabbleFloat value minus input value
     */
    @Override
    public INumber subtract(IStandard iStandard) {
        return iStandard.subtractToFloat(this);
    }

    /**
     * Divides a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return
     *      a new ScrabbleFloat containing the result of ScrabbleFloat input value divided by
     *      the ScrabbleFloat value
     */
    @Override
    public INumber divideFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()/this.value);
    }

    /**
     * Divides the ScrabbleFloat by an IStandard number
     * @param iStandard the IStandard object
     * @return a new INumber containing the result of division
     */
    @Override
    public INumber divideBy(IStandard iStandard) {
        return iStandard.divideFloat(this);
    }

    /**
     * Divides the ScrabbleFloat by an IEncodedInteger number
     * @param iEncodedInteger the IEncodedInteger object
     * @return a new INumber containing the division result
     */
    public INumber divideBy(IEncodedInteger iEncodedInteger) {
        return iEncodedInteger.transformToScrabbleInt().divideFloat(this);
    }

    /**
     * Multiplies a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new ScrabbleFloat containing the multiplication of its values
     */
    @Override
    public INumber multiplyFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()*this.value);
    }

    /**
     * Multiplies an IStandard number
     * @param iStandard the IStandard object
     * @return a new INumber containing the result
     */
    @Override
    public INumber multiplyBy(IStandard iStandard) {
        return iStandard.multiplyFloat(this);
    }

    /**
     * Multiplies an IEncodedInteger
     * @param iEncodedInteger the IEncodedInteger object
     * @return a new INumber number containing the multiplication between its values
     */
    @Override
    public INumber multiplyBy(IEncodedInteger iEncodedInteger) {
        return iEncodedInteger.transformToScrabbleInt().multiplyFloat(this);
    }

    /**
     * Sums an IEncodedInteger
     * @param iEncodedInteger the IEncodedInteger object
     * @return a new INumber containing the sum of its values
     */
    public INumber sum(IEncodedInteger iEncodedInteger) {
        return iEncodedInteger.transformToScrabbleInt().sumFloat(this);
    }

    /**
     * Subtracts an IEncodedInteger
     * @param iEncodedInteger the IEncodedInteger object
     * @return
     *      a new IEncodedInteger containing the result of
     *      the ScrabbleFloat value minus the IEncodedInteger value
     */
    public INumber subtract(IEncodedInteger iEncodedInteger) {
        return iEncodedInteger.transformToScrabbleFloat().subtractToFloat(this);
    }
}
