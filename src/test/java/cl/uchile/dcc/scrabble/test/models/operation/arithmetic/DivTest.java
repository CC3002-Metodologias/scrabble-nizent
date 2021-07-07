package cl.uchile.dcc.scrabble.test.models.operation.arithmetic;

import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Div;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;
import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.IntConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivTest extends AbstractOperationTest{
    Div op;

    @BeforeEach
    void init(){
        op = new Div(floatConstant, new Sub(binConstant, intConstant));
    }
    @Test
    void constructorTest() {
        assertEquals(new Div(floatConstant, new Sub(binConstant, intConstant)), op);
        assertEquals((new Div(floatConstant, new Sub(binConstant, intConstant))).hashCode(),
                op.hashCode());
        assertNotEquals(new Div(floatConstant, binConstant), op);
        assertNotEquals(op, new Sub(floatConstant, binConstant));
    }

    @Test
    void toStringTest(){
        assertEquals("Div{SFloat(9.5), Sub{SBin(0101), SInt(7)}}", op.toString());
    }

    @Test
    void evaluateTest(){
        operation = new Div(intConstant, floatConstant);
        assertEquals(new FloatConstant(new ScrabbleFloat(intValue/doubleValue)),
                operation.evaluate());
        operation = new Div(intConstant, binConstant);
        assertEquals(new IntConstant(new ScrabbleInt(intValue/5)),
                operation.evaluate());
        operation = new Div(intConstant, intConstant);
        assertEquals(new IntConstant(new ScrabbleInt(1)),
                operation.evaluate());
        operation = new Div(intConstant, stringConstant);
        assertNull(operation.evaluate());
        operation = new Div(intConstant, boolConstant);
        assertNull(operation.evaluate());

        operation = new Div(floatConstant, floatConstant);
        assertEquals(new FloatConstant(new ScrabbleFloat(1)),
                operation.evaluate());
        operation = new Div(floatConstant, binConstant);
        assertEquals(new FloatConstant(new ScrabbleFloat(doubleValue/5)),
                operation.evaluate());
        operation = new Div(floatConstant, boolConstant);
        assertNull(operation.evaluate());
        operation = new Div(floatConstant, stringConstant);
        assertNull(operation.evaluate());
        operation = new Div(binConstant, binConstant);
        assertEquals(new BinConstant(new ScrabbleBinary("01")),
                operation.evaluate());
        operation = new Div(binConstant, boolConstant);
        assertNull(operation.evaluate());
        operation = new Div(binConstant, stringConstant);
        assertNull(operation.evaluate());
        operation = new Div(stringConstant, floatConstant);
        assertNull(operation.evaluate());
        operation = new Div(stringConstant, binConstant);
        assertNull(operation.evaluate());
        operation = new Div(stringConstant, intConstant);
        assertNull(operation.evaluate());
        operation = new Div(stringConstant, stringConstant);
        assertNull(operation.evaluate());
        operation = new Div(stringConstant, boolConstant);
        assertNull(operation.evaluate());


    }
}