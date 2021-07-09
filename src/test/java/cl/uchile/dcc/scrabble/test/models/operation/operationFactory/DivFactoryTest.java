package cl.uchile.dcc.scrabble.test.models.operation.operationFactory;

import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Div;
import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.BoolConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;
import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.operation.logical.And;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.AndFactory;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.DivFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBool;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivFactoryTest {
    @Test
    void createTest(){
        DivFactory divFactory = new DivFactory();
        Constant constant1 = new FloatConstant(new ScrabbleFloat(2));
        Constant constant2 = new BinConstant(new ScrabbleBinary("1"));
        Div op = new Div(constant1,
                new Add(constant2, constant2));
        assertEquals(op, divFactory.create(constant1,
                new Add(constant2, constant2)));
    }
}
