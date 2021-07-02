package cl.uchile.dcc.scrabble.models.operation.constantFactory;

import cl.uchile.dcc.scrabble.models.operation.constant.BoolConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBool;

import java.util.HashMap;
import java.util.Map;

public class BoolFactory {
    static Map<ScrabbleBool, BoolConstant> variable = new HashMap<>();

    public static BoolConstant getConstant(ScrabbleBool value){
        BoolConstant boolConstant = variable.get(value);
        if(boolConstant==null){
            boolConstant = new BoolConstant(value);
            variable.put(value, boolConstant);
        }
        return boolConstant;
    }
}
