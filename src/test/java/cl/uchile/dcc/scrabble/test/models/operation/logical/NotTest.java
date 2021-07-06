package cl.uchile.dcc.scrabble.test.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.logical.Not;
import cl.uchile.dcc.scrabble.models.operation.logical.Or;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotTest extends LogicalOperationTest {
    @Test
    void evaluateTest(){
        operation = new Not(trueBool);
        assertEquals(falseBool, operation.evaluate());
        operation = new Not(new Or(trueBool, falseBool));
        assertEquals(falseBool, operation.evaluate());
    }
}
