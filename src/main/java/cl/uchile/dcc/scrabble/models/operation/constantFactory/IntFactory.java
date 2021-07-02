package cl.uchile.dcc.scrabble.models.operation.constantFactory;

import cl.uchile.dcc.scrabble.models.operation.constant.IntConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;

import java.util.HashMap;
import java.util.Map;

public class IntFactory {
    static Map<ScrabbleInt, IntConstant> variable = new HashMap<>();

    public static IntConstant getConstant(ScrabbleInt value){
        IntConstant intConstant = variable.get(value);
        if(intConstant==null){
            intConstant = new IntConstant(value);
            variable.put(value, intConstant);
        }
        return intConstant;
    }
}
