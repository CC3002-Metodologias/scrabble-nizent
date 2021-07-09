package cl.uchile.dcc.scrabble.models.operation.constantFactory;

import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Factory that creates BinConstant objects.
 * Uses Flyweight Pattern to optimize the usage of memory
 */
public class BinFactory implements ConstantFactory{
    private static Map<ScrabbleBinary, BinConstant> variable = new HashMap<>();

    /**
     * Gets a constant from the factory (from the "variable" Map), and if it doesn't
     * exists, it creates a new Constant and save it in the factory
     * @param value the Scrabble Binary object
     * @return a BinConstant containing the value
     */
    public static BinConstant getConstant(ScrabbleBinary value){
        BinConstant binConstant = variable.get(value);
        if(binConstant==null){
            binConstant = new BinConstant(value);
            variable.put(value, binConstant);
        }
        return binConstant;
    }
}
