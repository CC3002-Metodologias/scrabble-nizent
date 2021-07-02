package cl.uchile.dcc.scrabble.test.models.operation.arithmetic;

import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.constant.*;
import cl.uchile.dcc.scrabble.models.operation.logical.And;
import cl.uchile.dcc.scrabble.models.type.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AddTest extends AbstractOperationTest{
    @Test
    void evaluateTest(){
        operation = new Add(intConstant, floatConstant);
        assertEquals(new FloatConstant(new ScrabbleFloat(intValue+doubleValue)),
                operation.evaluate());
        operation = new Add(intConstant, binConstant);
        assertEquals(new IntConstant(new ScrabbleInt(intValue+5)),
                operation.evaluate());
        operation = new Add(intConstant, intConstant);
        assertEquals(new IntConstant(new ScrabbleInt(intValue+intValue)),
                operation.evaluate());
        operation = new Add(intConstant, stringConstant);
        assertNull(operation.evaluate());
        operation = new Add(intConstant, boolConstant);
        assertNull(operation.evaluate());
        operation = new Add(floatConstant, floatConstant);
        assertEquals(new FloatConstant(new ScrabbleFloat(doubleValue+doubleValue)),
                operation.evaluate());
        operation = new Add(floatConstant, binConstant);
        assertEquals(new FloatConstant(new ScrabbleFloat(doubleValue+5)),
                operation.evaluate());
        operation = new Add(floatConstant, boolConstant);
        assertNull(operation.evaluate());
        operation = new Add(floatConstant, stringConstant);
        assertNull(operation.evaluate());
        operation = new Add(binConstant, binConstant);
        assertEquals(new BinConstant(new ScrabbleBinary("01010")),
                operation.evaluate());
        operation = new Add(binConstant, boolConstant);
        assertNull(operation.evaluate());
        operation = new Add(binConstant, stringConstant);
        assertNull(operation.evaluate());
        operation = new Add(stringConstant, floatConstant);
        assertEquals(new StringConstant(new ScrabbleString(stringValue+doubleValue)),
                operation.evaluate());
        operation = new Add(stringConstant, binConstant);
        assertEquals(new StringConstant(new ScrabbleString(stringValue).sum(new ScrabbleBinary(binValue))),
                operation.evaluate());
        operation = new Add(stringConstant, intConstant);
        assertEquals(new StringConstant(new ScrabbleString(stringValue+intValue)),
                operation.evaluate());
        operation = new Add(stringConstant, stringConstant);
        assertEquals(new StringConstant(new ScrabbleString(stringValue+stringValue)),
                operation.evaluate());
        operation = new Add(stringConstant, boolConstant);
        assertEquals(new StringConstant(new ScrabbleString(stringValue+boolValue)),
                operation.evaluate());
        // Add operations
        operation = new Add(new Add(floatConstant, binConstant), new And(boolConstant, binConstant));
        assertEquals(new FloatConstant(new ScrabbleFloat(5+doubleValue+5)),
                operation.evaluate());
    }
}