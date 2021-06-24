package cl.uchile.dcc.scrabble.test.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.logical.And;
import cl.uchile.dcc.scrabble.models.operation.logical.Or;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrTest extends AbstractLogicalOperationTest {
    @Test
    void evaluateTest(){
        operation = new Or(trueBool, falseBool);
        assertEquals(trueBool, operation.evaluate());
    }
}
