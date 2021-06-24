package cl.uchile.dcc.scrabble.test.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.BoolConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBool;
import org.junit.jupiter.api.BeforeEach;

public class AbstractLogicalOperationTest {
    Operation operation;
    BoolConstant trueBool;
    BoolConstant falseBool;

    @BeforeEach
    void setUp(){
        trueBool = new BoolConstant(new ScrabbleBool(true));
        falseBool = new BoolConstant(new ScrabbleBool(false));
    }
}
