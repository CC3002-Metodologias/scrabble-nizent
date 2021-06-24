package cl.uchile.dcc.scrabble.test.models.operation.arithmetic;

import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.constant.*;
import cl.uchile.dcc.scrabble.models.type.*;
import org.junit.jupiter.api.BeforeEach;

public class AbstractOperationTest {
    Operation operation;
    IntConstant intConstant;
    FloatConstant floatConstant;
    BoolConstant boolConstant;
    BinConstant binConstant;
    StringConstant stringConstant;
    int intValue;
    double doubleValue;
    String stringValue;
    String binValue;
    boolean boolValue;

    @BeforeEach
    void setUp(){
        intValue = 7;
        doubleValue = 9.5;
        stringValue = "Hola mundo";
        binValue = "0101";
        boolValue = true;
        intConstant = new IntConstant(new ScrabbleInt(intValue));
        floatConstant = new FloatConstant(new ScrabbleFloat(doubleValue));
        binConstant = new BinConstant(new ScrabbleBinary(binValue));
        boolConstant = new BoolConstant(new ScrabbleBool(boolValue));
        stringConstant = new StringConstant(new ScrabbleString(stringValue));
    }
}
