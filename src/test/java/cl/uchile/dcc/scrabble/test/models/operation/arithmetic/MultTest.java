package cl.uchile.dcc.scrabble.test.models.operation.arithmetic;

import cl.uchile.dcc.scrabble.models.operation.arithmetic.Div;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Mult;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;
import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.IntConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultTest extends AbstractOperationTest{
    Mult op;

    @BeforeEach
    void init(){
        op = new Mult(floatConstant, new Sub(binConstant, intConstant));
    }
    @Test
    void constructorTest() {
        assertEquals(new Mult(floatConstant, new Sub(binConstant, intConstant)), op);
        assertEquals((new Mult(floatConstant, new Sub(binConstant, intConstant))).hashCode(),
                op.hashCode());
        assertNotEquals(new Mult(floatConstant, binConstant), op);
        assertNotEquals(op, new Sub(floatConstant, binConstant));
    }

    @Test
    void toStringTest(){
        assertEquals("Mult{SFloat(9.5), Sub{SBin(0101), SInt(7)}}", op.toString());
    }

    @Test
    void evaluateTest(){
        operation = new Mult(intConstant, floatConstant);
        assertEquals(new FloatConstant(new ScrabbleFloat(intValue*doubleValue)),
                operation.evaluate());
        operation = new Mult(intConstant, binConstant);
        assertEquals(new IntConstant(new ScrabbleInt(intValue*5)),
                operation.evaluate());
        operation = new Mult(intConstant, intConstant);
        assertEquals(new IntConstant(new ScrabbleInt(intValue*intValue)),
                operation.evaluate());
        operation = new Mult(intConstant, stringConstant);
        assertNull(operation.evaluate());
        operation = new Mult(intConstant, boolConstant);
        assertNull(operation.evaluate());

        operation = new Mult(floatConstant, floatConstant);
        assertEquals(new FloatConstant(new ScrabbleFloat(doubleValue*doubleValue)),
                operation.evaluate());
        operation = new Mult(floatConstant, binConstant);
        assertEquals(new FloatConstant(new ScrabbleFloat(doubleValue*5)),
                operation.evaluate());
        operation = new Mult(floatConstant, boolConstant);
        assertNull(operation.evaluate());
        operation = new Mult(floatConstant, stringConstant);
        assertNull(operation.evaluate());
        operation = new Mult(binConstant, binConstant);
        assertEquals(new BinConstant(new ScrabbleInt(5*5).transformToScrabbleBinary()),
                operation.evaluate());
        operation = new Mult(binConstant, boolConstant);
        assertNull(operation.evaluate());
        operation = new Mult(binConstant, stringConstant);
        assertNull(operation.evaluate());
        operation = new Mult(stringConstant, floatConstant);
        assertNull(operation.evaluate());
        operation = new Mult(stringConstant, binConstant);
        assertNull(operation.evaluate());
        operation = new Mult(stringConstant, intConstant);
        assertNull(operation.evaluate());
        operation = new Mult(stringConstant, stringConstant);
        assertNull(operation.evaluate());
        operation = new Mult(stringConstant, boolConstant);
        assertNull(operation.evaluate());
    }
}