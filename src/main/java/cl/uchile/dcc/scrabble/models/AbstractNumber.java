package cl.uchile.dcc.scrabble.models;


/** An abstract class that holds the common behavior of a number
 * @author Nicolás Zenteno Guardia
 */

public abstract class AbstractNumber<T> extends AbstractScrabbleType<T> implements INumber<T> {
    /**
     * Creates a new Scrabble Number
     *
     * @param value String, int or double value
     */
    protected AbstractNumber(T value) {
        super(value);
    }

    /**
     * Check if a number is equal to another
     * @param obj the object to compare with
     * @return true if the object is a number and its value is equal than the number that calls the method, false in any other case
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof INumber){
            INumber<T> iNumber = (INumber<T>) obj;
            return this.transformToScrabbleFloat().toString().equals(iNumber.transformToScrabbleFloat().toString());
        }
        return false;
    }
}
