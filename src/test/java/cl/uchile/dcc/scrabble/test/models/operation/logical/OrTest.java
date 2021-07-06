package cl.uchile.dcc.scrabble.test.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.IntConstant;
import cl.uchile.dcc.scrabble.models.operation.logical.And;
import cl.uchile.dcc.scrabble.models.operation.logical.Or;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrTest extends LogicalOperationTest {
    @Test
    void evaluateTest(){
        operation = new Or(trueBool, falseBool);
        assertEquals(trueBool, operation.evaluate());
        operation = new Or(trueBool, binConstant);
        assertEquals(new BinConstant(new ScrabbleBinary("1")),
                operation.evaluate());
        operation = new Or(binConstant, binConstant);
        assertEquals(binConstant, operation.evaluate());
        assertNull((new Or(new FloatConstant(new ScrabbleFloat(1)),
                new IntConstant(new ScrabbleInt(2)))).evaluate());
        operation = new Or(trueBool, new And(trueBool, binConstant));
        assertEquals(new BinConstant(new ScrabbleBinary("1")), operation.evaluate());
        assertThrows(NullPointerException.class,
                ()->{(new Or(binConstant, new Or(new FloatConstant(new ScrabbleFloat(1)),
                new IntConstant(new ScrabbleInt(2))))).evaluate();});
    }
}
