package cl.uchile.dcc.scrabble.test.controller;

import cl.uchile.dcc.scrabble.controller.ASTController;
import cl.uchile.dcc.scrabble.controller.ScrabbleTypes;
import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;
import cl.uchile.dcc.scrabble.models.operation.constant.Constant;
import cl.uchile.dcc.scrabble.models.operation.constant.FloatConstant;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.*;
import cl.uchile.dcc.scrabble.models.operation.logical.Not;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.*;
import cl.uchile.dcc.scrabble.models.type.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ASTControllerTest {
    AddFactory add;
    SubFactory sub;
    MultFactory mult;
    DivFactory div;
    AndFactory and;
    OrFactory or;
    ScrabbleString sString;
    ScrabbleBinary sBin;
    ScrabbleFloat sFloat;
    ScrabbleInt sInt;
    ScrabbleBool sBool;
    ASTController ast;

    @BeforeEach
    void setUp(){
        add = new AddFactory();
        sub = new SubFactory();
        div = new DivFactory();
        mult = new MultFactory();
        and = new AndFactory();
        or = new OrFactory();
        ast = new ASTController();
        sString = new ScrabbleString("");
        sBin = new ScrabbleBinary("0");
        sInt = new ScrabbleInt(1);
        sBool = new ScrabbleBool(true);
        sFloat = new ScrabbleFloat(1);
    }

    @Test
    void addStringOperationTest(){
        assertEquals(add.create(StringFactory.getConstant(sString), FloatFactory.getConstant(sFloat)),
                ast.addStringOperation(sString, new FloatConstant(sFloat)));
    }

    @Test
    void operateFloatWithBinTest(){
        assertEquals(add.create(FloatFactory.getConstant(sFloat),
                BinFactory.getConstant(sBin)),
                ast.operateFloatWithBin(sFloat,sBin, add));
        assertEquals(mult.create(FloatFactory.getConstant(sFloat),
                BinFactory.getConstant(sBin)),
                ast.operateFloatWithBin(sFloat,sBin, mult));
    }

    @Test
    void operateFloatWithIntTest(){
        assertEquals(add.create(FloatFactory.getConstant(sFloat),
                IntFactory.getConstant(sInt)),
                ast.operateFloatWithInt(sFloat,sInt, add));
        assertEquals(mult.create(FloatFactory.getConstant(sFloat),
                IntFactory.getConstant(sInt)),
                ast.operateFloatWithInt(sFloat,sInt, mult));
    }

    @Test
    void operateFloatWithFloatTest(){
        assertEquals(add.create(FloatFactory.getConstant(sFloat),
                FloatFactory.getConstant(sFloat)),
                ast.operateFloatWithFloat(sFloat,sFloat, add));
        assertEquals(mult.create(FloatFactory.getConstant(sFloat),
                FloatFactory.getConstant(sFloat)),
                ast.operateFloatWithFloat(sFloat,sFloat, mult));
    }

    @Test
    void operateIntWithFloatTest(){
        assertEquals(add.create(IntFactory.getConstant(sInt),
                FloatFactory.getConstant(sFloat)),
                ast.operateIntWithFloat(sInt,sFloat, add));
        assertEquals(mult.create(IntFactory.getConstant(sInt),
                FloatFactory.getConstant(sFloat)),
                ast.operateIntWithFloat(sInt,sFloat, mult));
    }

    @Test
    void operateIntWithBinTest(){
        assertEquals(add.create(IntFactory.getConstant(sInt),
                BinFactory.getConstant(sBin)),
                ast.operateIntWithBin(sInt,sBin, add));
        assertEquals(mult.create(IntFactory.getConstant(sInt),
                BinFactory.getConstant(sBin)),
                ast.operateIntWithBin(sInt,sBin, mult));
    }

    @Test
    void operateIntWithIntTest(){
        assertEquals(add.create(IntFactory.getConstant(sInt),
                IntFactory.getConstant(sInt)),
                ast.operateIntWithInt(sInt,sInt, add));
        assertEquals(mult.create(IntFactory.getConstant(sInt),
                IntFactory.getConstant(sInt)),
                ast.operateIntWithInt(sInt,sInt, mult));
    }

    @Test
    void operateBinWithIntTest(){
        assertEquals(add.create(BinFactory.getConstant(sBin),
                IntFactory.getConstant(sInt)),
                ast.operateBinWithInt(sBin,sInt, add));
        assertEquals(mult.create(BinFactory.getConstant(sBin),
                IntFactory.getConstant(sInt)),
                ast.operateBinWithInt(sBin,sInt, mult));
    }

    @Test
    void operateBinWithBinTest(){
        assertEquals(add.create(BinFactory.getConstant(sBin),
                BinFactory.getConstant(sBin)),
                ast.operateBinWithBin(sBin,sBin, add));
        assertEquals(mult.create(BinFactory.getConstant(sBin),
                BinFactory.getConstant(sBin)),
                ast.operateBinWithBin(sBin,sBin, mult));
    }

    @Test
    void logicOpBinWithBoolTest(){
        assertEquals(and.create(BinFactory.getConstant(sBin),
                BoolFactory.getConstant(sBool)),
                ast.logicOpBinWithBool(sBin,sBool, and));
        assertEquals(or.create(BinFactory.getConstant(sBin),
                BoolFactory.getConstant(sBool)),
                ast.logicOpBinWithBool(sBin,sBool, or));
    }

    @Test
    void logicOpBinWithBinTest(){
        assertEquals(and.create(BinFactory.getConstant(sBin),
                BinFactory.getConstant(sBin)),
                ast.logicOpBinWithBin(sBin,sBin, and));
        assertEquals(or.create(BinFactory.getConstant(sBin),
                BinFactory.getConstant(sBin)),
                ast.logicOpBinWithBin(sBin,sBin, or));
    }

    @Test
    void logicOpBoolWithBinTest(){
        assertEquals(and.create(BoolFactory.getConstant(sBool),
                BinFactory.getConstant(sBin)),
                ast.logicOpBoolWithBin(sBool,sBin, and));
        assertEquals(or.create(BoolFactory.getConstant(sBool),
                BinFactory.getConstant(sBin)),
                ast.logicOpBoolWithBin(sBool,sBin, or));
    }

    @Test
    void logicOpBoolWithBoolTest(){
        assertEquals(and.create(BoolFactory.getConstant(sBool),
                BoolFactory.getConstant(sBool)),
                ast.logicOpBoolWithBool(sBool,sBool, and));
        assertEquals(or.create(BoolFactory.getConstant(sBool),
                BoolFactory.getConstant(sBool)),
                ast.logicOpBoolWithBool(sBool,sBool, or));
    }

    @Test
    void negateBoolTest(){
        assertEquals(new Not(BoolFactory.getConstant(sBool)),
                ast.negateBool(sBool));
    }

    @Test
    void negateBinTest(){
        assertEquals(new Not(BinFactory.getConstant(sBin)),
                ast.negateBin(sBin));
    }

    @Test
    void addTest(){
        String id = ScrabbleTypes.ADD_ID+"0";
        ast.add(id);
        assertNull(ast.getAST(id).getMainEntity());
        id = ScrabbleTypes.SUB_ID+"0";
        ast.add(id);
        assertNull(ast.getAST(id).getMainEntity());
        id = ScrabbleTypes.DIV_ID+"0";
        ast.add(id);
        assertNull(ast.getAST(id).getMainEntity());
        id = ScrabbleTypes.MULT_ID+"0";
        ast.add(id);
        assertNull(ast.getAST(id).getMainEntity());
        id = ScrabbleTypes.AND_ID+"0";
        ast.add(id);
        assertNull(ast.getAST(id).getMainEntity());
        id = ScrabbleTypes.OR_ID+"0";
        ast.add(id);
        assertNull(ast.getAST(id).getMainEntity());
        id = ScrabbleTypes.NOT_ID+"0";
        ast.add(id);
        assertNull(ast.getAST(id).getMainEntity());
        id = ScrabbleTypes.STR_ID+"0";
        OperableEntity value = StringFactory.getConstant(new ScrabbleString(""));
        ast.add(id);
        assertEquals(value, ast.getAST(id).getMainEntity());
        id = ScrabbleTypes.FLOAT_ID+"0";
        value = FloatFactory.getConstant(new ScrabbleFloat(0));
        ast.add(id);
        assertEquals(value, ast.getAST(id).getMainEntity());
        id = ScrabbleTypes.INT_ID+"0";
        value = IntFactory.getConstant(new ScrabbleInt(0));
        ast.add(id);
        assertEquals(value, ast.getAST(id).getMainEntity());
        id = ScrabbleTypes.BIN_ID+"0";
        value = BinFactory.getConstant(new ScrabbleBinary("0"));
        ast.add(id);
        assertEquals(value, ast.getAST(id).getMainEntity());
        id = ScrabbleTypes.BOOL_ID+"0";
        value = BoolFactory.getConstant(new ScrabbleBool(true));
        ast.add(id);
        assertEquals(value, ast.getAST(id).getMainEntity());
    }

    @Test
    public void addLeftOperandTest(){
        String id = ScrabbleTypes.ADD_ID+"0";
        ast.add(id);
        assertNull(ast.getAST(id).getMainEntity());
        String left_id = ScrabbleTypes.INT_ID+"0";
        ast.add(left_id);
        ast.addLeftOperand(id, left_id);
        assertEquals(IntFactory.getConstant(new ScrabbleInt(0)), ast.getAST(id).getLeft().evaluate());
    }

    @Test
    public void addRightOperandTest(){
        String id = ScrabbleTypes.ADD_ID+"0";
        ast.add(id);
        assertNull(ast.getAST(id).getMainEntity());
        String right_id = ScrabbleTypes.INT_ID+"0";
        ast.add(right_id);
        ast.addRightOperand(id, right_id);
        assertEquals(IntFactory.getConstant(new ScrabbleInt(0)), ast.getAST(id).getRight().evaluate());
    }

    @Test
    public void updateConstantTest(){
        String id = ScrabbleTypes.STR_ID;
        String value = "value";
        ast.add(id);
        ast.updateConstant(id,value);
        assertEquals(value, ast.evaluate(id));
        id = ScrabbleTypes.BIN_ID;
        value = "101";
        ast.add(id);
        ast.updateConstant(id,value);
        assertEquals(value, ast.evaluate(id));
        id = ScrabbleTypes.INT_ID;
        value = "107";
        ast.add(id);
        ast.updateConstant(id,value);
        assertEquals(value, ast.evaluate(id));
        id = ScrabbleTypes.INT_ID+"1";
        value = "107mmm";
        ast.add(id);
        ast.updateConstant(id,value);
        assertEquals("Tree not correctly built", ast.evaluate(id));
        id = ScrabbleTypes.FLOAT_ID;
        value = "10.1";
        ast.add(id);
        ast.updateConstant(id,value);
        assertEquals(value, ast.evaluate(id));
        id = ScrabbleTypes.FLOAT_ID+"1";
        value = "107mm.m";
        ast.add(id);
        ast.updateConstant(id,value);
        assertEquals("Tree not correctly built", ast.evaluate(id));
        id = ScrabbleTypes.BOOL_ID;
        value = "true";
        ast.add(id);
        ast.updateConstant(id,value);
        assertEquals(value, ast.evaluate(id));
    }
}
