package cl.uchile.dcc.scrabble.models.operation.constantFactory;

import cl.uchile.dcc.scrabble.models.operation.constant.StringConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleString;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Factory that creates StringConstant objects
 * Uses Flyweight Pattern
 */
public class StringFactory implements ConstantFactory{
    private static Map<ScrabbleString, StringConstant> variable = new HashMap<>();

    /**
     * Gets a StringConstant containing the ScrabbleString value, optimizing memory
     * @param value the ScrabbleString value
     * @return a StringConstant containing the value
     */
    public static StringConstant getConstant(ScrabbleString value){
        StringConstant stringConstant = variable.get(value);
        if(stringConstant==null){
            stringConstant = new StringConstant(value);
            variable.put(value, stringConstant);
        }
        return stringConstant;
    }
}
