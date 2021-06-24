package cl.uchile.dcc.scrabble.test.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.logical.And;
import cl.uchile.dcc.scrabble.models.operation.logical.Not;
import cl.uchile.dcc.scrabble.test.models.operation.arithmetic.AbstractOperationTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotTest extends AbstractLogicalOperationTest {
    @Test
    void evaluateTest(){
        operation = new Not(trueBool);
        assertEquals(falseBool, operation.evaluate());
    }
}