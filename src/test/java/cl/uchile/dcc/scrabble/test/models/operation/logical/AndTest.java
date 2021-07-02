package cl.uchile.dcc.scrabble.test.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.logical.And;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AndTest extends AbstractLogicalOperationTest {
    @Test
    void evaluateTest(){
        operation = new And(trueBool, falseBool);
        assertEquals(falseBool, operation.evaluate());
    }
}
