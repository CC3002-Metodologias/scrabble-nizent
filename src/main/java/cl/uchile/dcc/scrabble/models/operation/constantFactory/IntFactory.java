package cl.uchile.dcc.scrabble.models.operation.constantFactory;

import cl.uchile.dcc.scrabble.models.operation.constant.IntConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Factory that creates IntConstant objects
 * Uses Flyweight Pattern to optimize memory
 */
public class IntFactory implements ConstantFactory{
    private static Map<ScrabbleInt, IntConstant> variable = new HashMap<>();

    /**
     * Gets an IntConstant containing the ScrabbleInt value, optimizing memory
     * @param value the ScrabbleInt value
     * @return an IntConstant containing the value
     */
    public static IntConstant getConstant(ScrabbleInt value){
        IntConstant intConstant = variable.get(value);
        if(intConstant==null){
            intConstant = new IntConstant(value);
            variable.put(value, intConstant);
        }
        return intConstant;
    }
}
