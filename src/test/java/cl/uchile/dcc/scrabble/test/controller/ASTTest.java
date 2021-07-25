package cl.uchile.dcc.scrabble.test.controller;

import cl.uchile.dcc.scrabble.controller.AST;
import cl.uchile.dcc.scrabble.gui.Scrabble;
import cl.uchile.dcc.scrabble.models.operation.constant.StringConstant;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.StringFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ASTTest {
    @Test
    void Test1(){
        AST x = new AST("Add");
        AST left = new AST("String");
        ScrabbleString val = new ScrabbleString("hi world");
        left.setMainEntity(StringFactory.getConstant(val));
        assertEquals(new StringConstant(val),left.evaluate());

    }
}
