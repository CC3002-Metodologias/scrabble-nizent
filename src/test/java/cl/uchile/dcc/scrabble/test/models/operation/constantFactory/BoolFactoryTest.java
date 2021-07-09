package cl.uchile.dcc.scrabble.test.models.operation.constantFactory;

import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.BoolConstant;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.BinFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.BoolFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBool;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoolFactoryTest {
    @Test
    void getConstantTest(){
        assertEquals(new BoolConstant(new ScrabbleBool(true)),
                BoolFactory.getConstant(new ScrabbleBool(true)));
    }
}
