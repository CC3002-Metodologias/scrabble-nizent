package cl.uchile.dcc.scrabble.test.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.IntConstant;
import cl.uchile.dcc.scrabble.models.operation.logical.And;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AndTest extends LogicalOperationTest {
    @Test
    void evaluateTest(){
        operation = new And(trueBool, falseBool);
        assertEquals(falseBool, operation.evaluate());
        operation = new And(trueBool, binConstant);
        assertEquals(binConstant, operation.evaluate());
        operation = new And(binConstant, binConstant);
        assertEquals(binConstant, operation.evaluate());
        assertNull((new And(new FloatConstant(new ScrabbleFloat(1)),
                new IntConstant(new ScrabbleInt(2)))).evaluate());
        operation = new And(trueBool, new And(trueBool, binConstant));
        assertEquals(binConstant, operation.evaluate());
    }
}
