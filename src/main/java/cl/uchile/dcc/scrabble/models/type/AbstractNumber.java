package cl.uchile.dcc.scrabble.models.type;


/** An abstract class that holds the common behavior of a number
 * @author Nicolás Zenteno Guardia
 */

public abstract class AbstractNumber extends AbstractScrabbleType implements INumber {

    /**
     * Checks if a number is equal to another
     * @param obj the object to compare with
     * @return true if the object is a number and its value is equal than the number that calls the method, false in any other case
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof AbstractNumber){
            AbstractNumber number = (AbstractNumber) obj;
            return this.transformToScrabbleFloat().toString().equals(number.transformToScrabbleFloat().toString());
        }
        return false;
    }

    /**
     * transforms a Scrabble number to a Scrabble Float
     * @return the equivalent Scrabble Float
     */
    public abstract ScrabbleFloat transformToScrabbleFloat();

    /**
     * Sum a Scrabble Int object
     * @param scrabbleInt the Scrabble Int object
     * @return the INumber result by summing both object values
     */
    public abstract IStandard sumToInt(ScrabbleInt scrabbleInt);

    /**
     * Subtracts to a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return an INumber containing the subtraction result
     */
    public abstract IStandard subtractToInt(ScrabbleInt scrabbleInt);

    /**
     * Divides a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return an INumber containing the division result
     */
    public abstract IStandard divideToInt(ScrabbleInt scrabbleInt);

    /**
     * Multiplies a ScrabbleInt
     * @param scrabbleInt the ScrabbleInt object
     * @return an INumber containing the multiplication result
     */
    public abstract IStandard multiplyToInt(ScrabbleInt scrabbleInt);

    /**
     * Sum a Scrabble Float object
     * @param scrabbleFloat the Scrabble Float object
     * @return the INumber result by summing both objects
     */
    public abstract ScrabbleFloat sumToFloat(ScrabbleFloat scrabbleFloat);

    /**
     * Subtracts to a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new INumber containing the result
     */
    public abstract ScrabbleFloat subtractToFloat(ScrabbleFloat scrabbleFloat);

    /**
     * Divides a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new INumber containing the division result between values
     */
    public abstract ScrabbleFloat divideToFloat(ScrabbleFloat scrabbleFloat);

    /**
     * Multiplies a ScrabbleFloat
     * @param scrabbleFloat the ScrabbleFloat object
     * @return a new INumber containing the multiplication of its values
     */
    public abstract ScrabbleFloat multiplyToFloat(ScrabbleFloat scrabbleFloat);
}