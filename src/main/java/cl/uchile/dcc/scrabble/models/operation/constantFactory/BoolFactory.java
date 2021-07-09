package cl.uchile.dcc.scrabble.models.operation.constantFactory;

import cl.uchile.dcc.scrabble.models.operation.constant.BoolConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBool;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Factory that creates BoolConstant objects
 * Uses Flyweight Pattern
 */
public class BoolFactory implements ConstantFactory{
    private static Map<ScrabbleBool, BoolConstant> variable = new HashMap<>();

    /**
     * Get the constant containing the Scrabble Bool value, optimizing the memory
     * @param value the Scrabble Bool value
     * @return a BoolConstant containing value
     */
    public static BoolConstant getConstant(ScrabbleBool value){
        BoolConstant boolConstant = variable.get(value);
        if(boolConstant==null){
            boolConstant = new BoolConstant(value);
            variable.put(value, boolConstant);
        }
        return boolConstant;
    }
}
