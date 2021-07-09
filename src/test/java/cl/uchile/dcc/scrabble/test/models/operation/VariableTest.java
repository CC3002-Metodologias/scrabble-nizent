package cl.uchile.dcc.scrabble.test.models.operation;

import cl.uchile.dcc.scrabble.models.operation.Variable;
import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.BinFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VariableTest {
    @Test
    void evaluateTest(){
        Variable x = new Variable("x");
        BinConstant binConstant = BinFactory.getConstant(new ScrabbleBinary("0"));
        x.assign(binConstant);
        assertEquals(binConstant,x.evaluate());
    }
}
