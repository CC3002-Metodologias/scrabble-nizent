package cl.uchile.dcc.scrabble.test.models.operation.arithmetic;

import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;
import cl.uchile.dcc.scrabble.models.operation.constant.*;
import cl.uchile.dcc.scrabble.models.type.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SubTest extends AbstractOperationTest{
    @Test
    void evaluateTest(){
        operation = new Sub(intConstant, floatConstant);
        assertEquals(new FloatConstant(new ScrabbleFloat(intValue-doubleValue)),
                operation.evaluate());
        operation = new Sub(intConstant, binConstant);
        assertEquals(new IntConstant(new ScrabbleInt(intValue-5)),
                operation.evaluate());
        operation = new Sub(intConstant, intConstant);
        assertEquals(new IntConstant(new ScrabbleInt(intValue-intValue)),
                operation.evaluate());
        operation = new Sub(intConstant, stringConstant);
        assertNull(operation.evaluate());
        operation = new Sub(intConstant, boolConstant);
        assertNull(operation.evaluate());
        operation = new Sub(floatConstant, floatConstant);
        assertEquals(new FloatConstant(new ScrabbleFloat(doubleValue-doubleValue)),
                operation.evaluate());
        operation = new Sub(floatConstant, binConstant);
        assertEquals(new FloatConstant(new ScrabbleFloat(doubleValue-5)),
                operation.evaluate());
        operation = new Sub(floatConstant, boolConstant);
        assertNull(operation.evaluate());
        operation = new Sub(floatConstant, stringConstant);
        assertNull(operation.evaluate());
        operation = new Sub(binConstant, binConstant);
        assertEquals(new BinConstant(new ScrabbleBinary("0")),
                operation.evaluate());
        operation = new Sub(binConstant, boolConstant);
        assertNull(operation.evaluate());
        operation = new Sub(binConstant, stringConstant);
        assertNull(operation.evaluate());
    }
}