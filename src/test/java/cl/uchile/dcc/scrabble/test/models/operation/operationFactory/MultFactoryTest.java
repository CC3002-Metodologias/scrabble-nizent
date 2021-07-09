package cl.uchile.dcc.scrabble.test.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Div;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Mult;
import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;
import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.DivFactory;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.MultFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultFactoryTest {
    @Test
    void createTest(){
        MultFactory multFactory = new MultFactory();
        Constant constant1 = new FloatConstant(new ScrabbleFloat(2));
        Constant constant2 = new BinConstant(new ScrabbleBinary("1"));
        Mult op = new Mult(constant1,
                new Add(constant2, constant2));
        assertEquals(op, multFactory.create(constant1,
                new Add(constant2, constant2)));
    }
}
