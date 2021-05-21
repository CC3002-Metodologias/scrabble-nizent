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
     * {@inheritDoc}
     */
    public ScrabbleFloat transformToScrabbleFloat(){
        return new ScrabbleFloat(this.value);
    }

    /**
     * Returns the value of the Scrabble Float
     * @return value
     */
    @Override
    public Double Value(){
        return this.value;
    }

    /**
     * Set value of Scrabble Double
     * @param value double
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @inheritDoc
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

    @Override
    public INumber sumInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleFloat(this.value+scrabbleInt.Value());
    }

    @Override
    public INumber subtractToInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleFloat(scrabbleInt.Value()-this.value);
    }

    @Override
    public INumber divideToInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleFloat(scrabbleInt.Value()/this.value);
    }

    @Override
    public INumber multiplyInt(ScrabbleInt scrabbleInt) {
        return new ScrabbleFloat(scrabbleInt.Value()*this.value);
    }

    @Override
    public INumber sumFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(this.value+scrabbleFloat.Value());
    }

    @Override
    public INumber sum(IStandard iNumber) {
        return iNumber.sumFloat(this);
    }

    @Override
    public INumber subtractToFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()-this.value);
    }

    @Override
    public INumber subtract(IStandard iNumber) {
        return iNumber.subtractToFloat(this);
    }

    @Override
    public INumber divideFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()/this.value);
    }

    @Override
    public INumber divideBy(IStandard iStandard) {
        return iStandard.divideFloat(this);
    }

    public INumber divideBy(IEncodedInteger iEncodedInteger) {
        return iEncodedInteger.transformToScrabbleInt().divideFloat(this);
    }

    @Override
    public INumber multiplyFloat(ScrabbleFloat scrabbleFloat) {
        return new ScrabbleFloat(scrabbleFloat.Value()*this.value);
    }

    @Override
    public INumber multiplyBy(IStandard iStandard) {
        return iStandard.multiplyFloat(this);
    }

    @Override
    public INumber multiplyBy(IEncodedInteger iEncodedInteger) {
        return iEncodedInteger.transformToScrabbleInt().multiplyFloat(this);
    }

    public INumber sum(IEncodedInteger iInteger) {
        return iInteger.transformToScrabbleInt().sumFloat(this);
    }

    public INumber subtract(IEncodedInteger iEncodedInteger) {
        return iEncodedInteger.transformToScrabbleFloat().subtractToFloat(this);
    }
}
