package cl.uchile.dcc.scrabble.test.models.operation.constantFactory;

import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.BinFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinFactoryTest {
    @Test
    void getConstantTest(){
        assertEquals(new BinConstant(new ScrabbleBinary("1")),
                BinFactory.getConstant(new ScrabbleBinary("1")));
    }
}
