package cl.uchile.dcc.scrabble.test.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;
import cl.uchile.dcc.scrabble.models.operation.logical.Not;
import cl.uchile.dcc.scrabble.models.operation.logical.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NotTest extends LogicalOperationTest {
    Not op;

    @BeforeEach
    void init(){
        op = new Not(new Or(trueBool, new Sub(binConstant, binConstant)));
    }

    @Test
    void constructorTest() {
        assertEquals(new Not(new Or(trueBool, new Sub(binConstant, binConstant))), op);
        assertEquals((new Not(new Or(trueBool, new Sub(binConstant, binConstant)))).hashCode(),
                op.hashCode());
        assertNotEquals(new Not(binConstant), op);
        assertNotEquals(op, new Add(binConstant, binConstant));
    }

    @Test
    void toStringTest(){
        assertEquals("Not{Or{SBool(true), Sub{SBin(101), SBin(101)}}}", op.toString());
    }

    @Test
    void evaluateTest(){
        operation = new Not(trueBool);
        assertEquals(falseBool, operation.evaluate());
        operation = new Not(new Or(trueBool, falseBool));
        assertEquals(falseBool, operation.evaluate());
    }
}
