package cl.uchile.dcc.scrabble.models.operation.constantFactory;

import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;

import java.util.HashMap;
import java.util.Map;

public class FloatFactory {
    static Map<ScrabbleFloat, FloatConstant> variable = new HashMap<>();

    public static FloatConstant getConstant(ScrabbleFloat value){
        FloatConstant floatConstant = variable.get(value);
        if(floatConstant==null){
            floatConstant = new FloatConstant(value);
            variable.put(value, floatConstant);
        }
        return floatConstant;
    }
}
