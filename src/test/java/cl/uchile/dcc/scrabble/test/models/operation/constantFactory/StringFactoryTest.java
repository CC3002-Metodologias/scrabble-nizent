package cl.uchile.dcc.scrabble.test.models.operation.constantFactory;

import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.StringConstant;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.BinFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.StringFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringFactoryTest {
    @Test
    void getConstantTest(){
        assertEquals(new StringConstant(new ScrabbleString("1")),
                StringFactory.getConstant(new ScrabbleString("1")));
    }
}
