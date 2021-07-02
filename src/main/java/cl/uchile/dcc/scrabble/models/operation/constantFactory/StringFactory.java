package cl.uchile.dcc.scrabble.models.operation.constantFactory;

import cl.uchile.dcc.scrabble.models.operation.constant.StringConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleString;

import java.util.HashMap;
import java.util.Map;

public class StringFactory {
    static Map<ScrabbleString, StringConstant> variable = new HashMap<>();

    public static StringConstant getConstant(ScrabbleString value){
        StringConstant stringConstant = variable.get(value);
        if(stringConstant==null){
            stringConstant = new StringConstant(value);
            variable.put(value, stringConstant);
        }
        return stringConstant;
    }
}
