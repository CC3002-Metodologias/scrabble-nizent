package cl.uchile.dcc.scrabble.test.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.constant.*;
import cl.uchile.dcc.scrabble.models.operation.logical.And;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.AddFactory;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.AndFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBool;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AndFactoryTest {
    @Test
    void createTest(){
        AndFactory andFactory = new AndFactory();
        Constant constant1 = new BoolConstant(new ScrabbleBool(true));
        Constant constant2 = new BinConstant(new ScrabbleBinary("1"));
        And op = new And(constant1,
                new Add(constant2, constant2));
        assertEquals(op, andFactory.create(constant1,
                new Add(constant2, constant2)));
    }
}
