package cl.uchile.dcc.scrabble.models.operation.constantFactory;

import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Factory that creates FloatConstant objects.
 * Uses Flyweight Pattern to optimize memory
 */
public class FloatFactory implements ConstantFactory{
    private static Map<ScrabbleFloat, FloatConstant> variable = new HashMap<>();

    /**
     * Gets a FloatConstant from Factory, optimizing memory
     * @param value the ScrabbleFloat value
     * @return a FloatConstant with the value
     */
    public static FloatConstant getConstant(ScrabbleFloat value){
        FloatConstant floatConstant = variable.get(value);
        if(floatConstant==null){
            floatConstant = new FloatConstant(value);
            variable.put(value, floatConstant);
        }
        return floatConstant;
    }
}
