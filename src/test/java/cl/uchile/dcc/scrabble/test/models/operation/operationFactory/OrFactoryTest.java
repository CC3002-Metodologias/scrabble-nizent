package cl.uchile.dcc.scrabble.test.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.BoolConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;
import cl.uchile.dcc.scrabble.models.operation.logical.And;
import cl.uchile.dcc.scrabble.models.operation.logical.Or;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.AndFactory;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.OrFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrFactoryTest {
    @Test
    void createTest(){
        OrFactory orFactory = new OrFactory();
        Constant constant1 = new BoolConstant(new ScrabbleBool(true));
        Constant constant2 = new BinConstant(new ScrabbleBinary("1"));
        Or op = new Or(constant1,
                new Add(constant2, constant2));
        assertEquals(op, orFactory.create(constant1,
                new Add(constant2, constant2)));
    }
}
