package cl.uchile.dcc.scrabble.models;

/**
 * This interface represents types of variables that have a value
 */
public interface IType<T> {
    /**
     * return the value of a type
     * @return the value of the type as an object
     */
    T Value();
}
