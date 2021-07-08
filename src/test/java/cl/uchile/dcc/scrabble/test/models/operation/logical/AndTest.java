package cl.uchile.dcc.scrabble.test.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;
import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.IntConstant;
import cl.uchile.dcc.scrabble.models.operation.logical.And;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AndTest extends LogicalOperationTest {
    And op;

    @BeforeEach
    void init(){
        op = new And(trueBool, new Sub(binConstant, binConstant));
    }
    @Test
    void constructorTest() {
        assertEquals(new And(trueBool, new Sub(binConstant, binConstant)), op);
        assertEquals((new And(trueBool, new Sub(binConstant, binConstant))).hashCode(),
                op.hashCode());
        assertNotEquals(new And(binConstant, binConstant), op);
        assertNotEquals(op, new Add(binConstant, binConstant));
    }

    @Test
    void toStringTest(){
        assertEquals("And{SBool(true), Sub{SBin(101), SBin(101)}}", op.toString());
    }

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
