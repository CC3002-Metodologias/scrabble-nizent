package cl.uchile.dcc.scrabble.models;

/**
 * This interface represents types of variables that have a value
 * @author Nicolás Zenteno Guardia
 */
public interface IType {
    /**
     * return the value of a type
     * @return the value of the type as an object
     */
    Object Value();

    /**
     * Transform the Scrabble object into a Scrabble String Object
     * @return A Scrabble String Object
     */
    ScrabbleString transformToScrabbleString();

}
