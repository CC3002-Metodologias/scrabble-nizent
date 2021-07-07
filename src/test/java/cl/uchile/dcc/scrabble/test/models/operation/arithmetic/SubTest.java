package cl.uchile.dcc.scrabble.test.models.operation.arithmetic;

import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Div;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Mult;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;
import cl.uchile.dcc.scrabble.models.operation.constant.*;
import cl.uchile.dcc.scrabble.models.type.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SubTest extends AbstractOperationTest{
    Sub op;

    @BeforeEach
    void init(){
        op = new Sub(floatConstant, new Sub(binConstant, intConstant));
    }
    @Test
    void constructorTest() {
        assertEquals(new Sub(floatConstant, new Sub(binConstant, intConstant)), op);
        assertEquals((new Sub(floatConstant, new Sub(binConstant, intConstant))).hashCode(),
                op.hashCode());
        assertNotEquals(new Sub(floatConstant, binConstant), op);
        assertNotEquals(op, new Add(floatConstant, binConstant));
    }

    @Test
    void toStringTest(){
        assertEquals("Sub{SFloat(9.5), Sub{SBin(0101), SInt(7)}}", op.toString());
    }

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