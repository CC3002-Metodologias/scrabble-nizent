package cl.uchile.dcc.scrabble.models;

/** An abstract class that holds the common behavior of an Scrabble Type
 * @author Nicolás Zenteno Guardia
 */
public abstract class AbstractScrabbleType<T> implements IType<T> {
    private T value;

    /**
     * Creates a new Scrabble String
     * @param value String value
     */
    protected AbstractScrabbleType(T value) {
        this.value=value;
    }
    /**
     * Returns the value of the Scrabble Object
     * @return value
     */
    @Override
    public T Value(){
        return this.value;
    }

    /**
     * Transform the value of the ScrabbleType to an String
     * @return the String containing the value
     */
    @Override
    public String toString(){
        return this.Value().toString();
    }
}
