package cl.uchile.dcc.scrabble.models;


/** An abstract class that holds the common behavior of a number
 * @author Nicolás Zenteno Guardia
 */

public abstract class AbstractNumber extends AbstractScrabbleType implements INumber {

    /**
     * Check if a number is equal to another
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

}
