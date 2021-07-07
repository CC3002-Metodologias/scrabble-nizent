package cl.uchile.dcc.scrabble.models.operation.constantFactory;

import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;

import java.util.HashMap;
import java.util.Map;

public class BinFactory implements ConstantFactory{
    private static Map<ScrabbleBinary, BinConstant> variable = new HashMap<>();

    public static BinConstant getConstant(ScrabbleBinary value){
        BinConstant binConstant = variable.get(value);
        if(binConstant==null){
            binConstant = new BinConstant(value);
            variable.put(value, binConstant);
        }
        return binConstant;
    }
}
