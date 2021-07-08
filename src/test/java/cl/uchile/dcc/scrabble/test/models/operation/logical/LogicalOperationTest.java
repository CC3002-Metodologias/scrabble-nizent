package cl.uchile.dcc.scrabble.test.models.operation.logical;

import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.constant.BinConstant;
import cl.uchile.dcc.scrabble.models.operation.constant.BoolConstant;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBool;
import org.junit.jupiter.api.BeforeEach;

public class LogicalOperationTest {
    Operation operation;
    BoolConstant trueBool;
    BoolConstant falseBool;
    BinConstant binConstant;

    @BeforeEach
    void setUp(){
        trueBool = new BoolConstant(new ScrabbleBool(true));
        falseBool = new BoolConstant(new ScrabbleBool(false));
        binConstant = new BinConstant(new ScrabbleBinary("101"));
    }
}
