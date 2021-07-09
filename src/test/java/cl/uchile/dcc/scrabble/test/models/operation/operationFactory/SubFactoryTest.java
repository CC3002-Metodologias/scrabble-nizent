package cl.uchile.dcc.scrabble.test.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Mult;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Sub;
import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;
import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.MultFactory;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.SubFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubFactoryTest {
    @Test
    void createTest(){
        SubFactory subFactory = new SubFactory();
        Constant constant1 = new FloatConstant(new ScrabbleFloat(2));
        Constant constant2 = new BinConstant(new ScrabbleBinary("1"));
        Sub op = new Sub(constant1,
                new Add(constant2, constant2));
        assertEquals(op, subFactory.create(constant1,
                new Add(constant2, constant2)));
    }
}
