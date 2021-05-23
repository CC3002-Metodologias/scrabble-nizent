package cl.uchile.dcc.scrabble.models;

/**
 * this interface represents logical types, that can be operated each other
 * @author Nicolás Zenteno Guardia
 */
public interface ILogic {
    /**
     * Makes a logical and operation with a ScrabbleBinary
     * @param scrabbleBinary the ScrabbleBinary object
     * @return an ILogic with the result of the and operation
     */
    ILogic andBinary(ScrabbleBinary scrabbleBinary);

    /**
     * Makes a logical and operation with a ScrabbleBool
     * @param scrabbleBool the ScrabbleBool object
     * @return an ILogic with the result of the and operation
     */
    ILogic andBool(ScrabbleBool scrabbleBool);

    /**
     * Makes a logical and operation with an ILogic
     * @param iLogic the ILogic object
     * @return an ILogic with the result
     */
    ILogic and(ILogic iLogic);

    /**
     * Makes a logical or operation with a ScrabbleBinary
     * @param scrabbleBinary the ScrabbleBinary object
     * @return an ILogic with the result of the or operation
     */
    ILogic orBinary(ScrabbleBinary scrabbleBinary);

    /**
     * Makes a logical or operation with a ScrabbleBool
     * @param scrabbleBool the ScrabbleBool object
     * @return an ILogic with the result of the or operation
     */
    ILogic orBool(ScrabbleBool scrabbleBool);

    /**
     * Makes a logical or operation with an ILogic
     * @param iLogic the ILogic object
     * @return an ILogic with the result
     */
    ILogic or(ILogic iLogic);
}
