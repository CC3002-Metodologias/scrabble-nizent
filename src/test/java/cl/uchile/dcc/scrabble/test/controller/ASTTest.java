package cl.uchile.dcc.scrabble.test.controller;

import cl.uchile.dcc.scrabble.controller.AST;
import cl.uchile.dcc.scrabble.controller.ScrabbleTypes;
import cl.uchile.dcc.scrabble.models.operation.constant.StringConstant;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.*;
import cl.uchile.dcc.scrabble.models.type.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ASTTest {
    String type;
    AST testAST;
    @BeforeEach
    void setUp(){
        type = ScrabbleTypes.STR_ID;
        testAST = new AST(type);
    }

    @Test
    void constructorTest(){
        String type = "String";
        assertEquals(type, (new AST(type)).getType());
    }

    @Test
    void getTypeTest(){
        assertEquals(type, testAST.getType());
    }

    @Test
    void setMainEntityTest(){
        testAST.setMainEntity(StringFactory.getConstant(new ScrabbleString("")));
        assertEquals(StringFactory.getConstant(new ScrabbleString("")), testAST.getMainEntity());
    }

    @Test
    void getMainEntityTest(){
        assertNull(testAST.getMainEntity());
    }

    @Test
    void setRightTest(){
        testAST.setRight(testAST);
        assertEquals(type, testAST.getRight().getType());
    }

    @Test
    void getRightTest(){
        assertNull(testAST.getRight());
    }

    @Test
    void setLeftTest(){
        testAST.setLeft(testAST);
        assertEquals(type, testAST.getLeft().getType());
    }

    @Test
    void getLeftTest(){
        assertNull(testAST.getLeft());
    }

    @Test
    void evaluateTest(){
        AST left = new AST(ScrabbleTypes.STR_ID);
        ScrabbleString val = new ScrabbleString("hi world");
        left.setMainEntity(StringFactory.getConstant(val));
        assertEquals(new StringConstant(val),left.evaluate());

        left = new AST(ScrabbleTypes.FLOAT_ID);
        left.setMainEntity(FloatFactory.getConstant(new ScrabbleFloat(9)));

        AST right = new AST(ScrabbleTypes.BIN_ID);
        right.setMainEntity(IntFactory.getConstant(new ScrabbleInt(0)));

        testAST = new AST(ScrabbleTypes.ADD_ID);
        testAST.setLeft(left);
        testAST.setRight(right);
        assertEquals(left.evaluate(), testAST.evaluate());

        testAST = new AST(ScrabbleTypes.SUB_ID);
        testAST.setLeft(left);
        testAST.setRight(right);
        assertEquals(left.evaluate(), testAST.evaluate());

        testAST = new AST(ScrabbleTypes.MULT_ID);
        testAST.setLeft(left);
        testAST.setRight(right);
        assertEquals(FloatFactory.getConstant(new ScrabbleFloat(0)),
                testAST.evaluate());

        testAST = new AST(ScrabbleTypes.DIV_ID);
        testAST.setLeft(right);
        testAST.setRight(left);
        assertEquals(FloatFactory.getConstant(new ScrabbleFloat(0)),
                testAST.evaluate());

        left = new AST(ScrabbleTypes.BOOL_ID);
        left.setMainEntity(BoolFactory.getConstant(new ScrabbleBool(true)));

        right = new AST(ScrabbleTypes.BOOL_ID);
        right.setMainEntity(BoolFactory.getConstant(new ScrabbleBool(true)));

        testAST = new AST(ScrabbleTypes.AND_ID);
        testAST.setLeft(left);
        testAST.setRight(right);
        assertEquals(left.evaluate(), testAST.evaluate());

        testAST = new AST(ScrabbleTypes.OR_ID);
        testAST.setLeft(left);
        testAST.setRight(right);
        assertEquals(left.evaluate(), testAST.evaluate());

        testAST = new AST(ScrabbleTypes.NOT_ID);
        testAST.setLeft(left);
        assertEquals(BoolFactory.getConstant(new ScrabbleBool(false)), testAST.evaluate());
    }
}
