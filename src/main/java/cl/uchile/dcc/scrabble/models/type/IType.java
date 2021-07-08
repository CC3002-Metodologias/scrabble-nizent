package cl.uchile.dcc.scrabble.models.type;

/**
 * This interface represents types of variables that have a value
 * @author Nicolás Zenteno Guardia
 */
public interface IType {
    /**
     * Transform the Scrabble object into a Scrabble String Object
     * @return A Scrabble String Object
     */
    ScrabbleString transformToScrabbleString();

}
