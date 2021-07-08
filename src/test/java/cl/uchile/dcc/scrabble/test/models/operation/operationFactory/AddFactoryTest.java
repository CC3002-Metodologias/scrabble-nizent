package cl.uchile.dcc.scrabble.test.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;
import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.IntConstant;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.AddFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddFactoryTest {
    @Test
    void createTest(){
        AddFactory addFactory = new AddFactory();
        Constant constant1 = new IntConstant(new ScrabbleInt(2));
        Constant constant2 = new FloatConstant(new ScrabbleFloat(3));
        Add op = new Add(constant1,
                constant2);
        assertEquals(op, addFactory.create(new IntConstant(new ScrabbleInt(2)),
                new FloatConstant(new ScrabbleFloat(3))));
    }
}
