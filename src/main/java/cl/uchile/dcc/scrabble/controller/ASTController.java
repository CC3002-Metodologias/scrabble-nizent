package cl.uchile.dcc.scrabble.controller;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.*;
import cl.uchile.dcc.scrabble.models.operation.logical.LogicalOperation;
import cl.uchile.dcc.scrabble.models.operation.logical.Not;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.ArithmeticOperationFactory;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.LogicalOperationFactory;
import cl.uchile.dcc.scrabble.models.type.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This class manages the correct construction of the operations
 */
public class ASTController {
    private final Map<String, AST> constructed = new HashMap<>();

    /**
     * Adds an AST to the list
     * @param id the AST id
     */
    public void add(String id){
        OperableEntity entity = null;
        String ast_type = "";
        if(id.contains(ScrabbleTypes.STR_ID)){
            ast_type = ScrabbleTypes.STR_ID;
            entity = StringFactory.getConstant(new ScrabbleString(""));
        } else if (id.contains(ScrabbleTypes.ADD_ID)){
            ast_type = ScrabbleTypes.ADD_ID;
        } else if (id.contains(ScrabbleTypes.FLOAT_ID)){
            ast_type = ScrabbleTypes.FLOAT_ID;
            entity = FloatFactory.getConstant(new ScrabbleFloat(0));
        } else if (id.contains(ScrabbleTypes.INT_ID)){
            ast_type = ScrabbleTypes.INT_ID;
            entity = IntFactory.getConstant(new ScrabbleInt(0));
        } else if (id.contains(ScrabbleTypes.BIN_ID)){
            ast_type = ScrabbleTypes.BIN_ID;
            entity = BinFactory.getConstant(new ScrabbleBinary("0"));
        } else if (id.contains(ScrabbleTypes.BOOL_ID)){
            ast_type = ScrabbleTypes.BOOL_ID;
            entity = BoolFactory.getConstant(new ScrabbleBool(true));
        } else if (id.contains(ScrabbleTypes.SUB_ID)){
            ast_type = ScrabbleTypes.SUB_ID;
        } else if (id.contains(ScrabbleTypes.DIV_ID)){
            ast_type = ScrabbleTypes.DIV_ID;
        } else if (id.contains(ScrabbleTypes.MULT_ID)){
            ast_type = ScrabbleTypes.MULT_ID;
        } else if (id.contains(ScrabbleTypes.AND_ID)){
            ast_type = ScrabbleTypes.AND_ID;
        } else if (id.contains(ScrabbleTypes.OR_ID)){
            ast_type = ScrabbleTypes.OR_ID;
        } else if (id.contains(ScrabbleTypes.NOT_ID)){
            ast_type = ScrabbleTypes.NOT_ID;
        }
        constructed.put(id, new AST(ast_type));
        constructed.get(id).setMainEntity(entity);
    }

    /**
     * Gets an AST by id
     * @param id the AST id
     * @return the respective AST
     */
    public AST getAST(String id){
        return constructed.get(id);
    }

    /**
     * Adds a left operand to an AST
     * @param op_id AST id
     * @param left_id left operand id
     */
    public void addLeftOperand(String op_id, String left_id){
        constructed.get(op_id).setLeft(constructed.get(left_id));
    }

    /**
     * Adds a right operand to an AST
     * @param op_id AST id
     * @param right_id right operand id
     */
    public void addRightOperand(String op_id, String right_id){
        constructed.get(op_id).setRight(constructed.get(right_id));
    }

    /**
     * Updates the constant value
     * @param id constant id
     * @param value new value
     */
    public void updateConstant(String id, String value){
        OperableEntity entity = null;
        if(id.contains(ScrabbleTypes.STR_ID)){
            entity = StringFactory.getConstant(new ScrabbleString(value));
        } else if (id.contains(ScrabbleTypes.FLOAT_ID)){
            try{
                entity = FloatFactory.getConstant(new ScrabbleFloat(Double.parseDouble(value)));
            } catch (NumberFormatException e){
                // do nothing
            }
        } else if (id.contains(ScrabbleTypes.INT_ID)){
            try {
                entity = IntFactory.getConstant(new ScrabbleInt(Integer.parseInt(value)));
            } catch (NumberFormatException e){
                // do nothing
            }
        } else if (id.contains(ScrabbleTypes.BIN_ID)){
            entity = BinFactory.getConstant(new ScrabbleBinary(value));
        } else if (id.contains(ScrabbleTypes.BOOL_ID)){
            entity = BoolFactory.getConstant(new ScrabbleBool(Boolean.parseBoolean(value)));
        }
        constructed.get(id).setMainEntity(entity);
    }

    /**
     * Evaluates the entity with the respective id
     * @param id the id
     * @return A string containing the result
     */
    public String evaluate(String id){
        String result;
        try {
            result = constructed.get(id).evaluate().toString();
        } catch (NullPointerException e){
            result = "(Tree not correctly built)";
        }
        int start = result.indexOf('(');
        int end = result.indexOf(')');
        return result.substring(start+1,end);
    }

    /**
     * Returns a new Add operation between a ScrabbleString and another entity
     * @param sString the ScrabbleString
     * @param operableEntity the right entity
     * @return the add operation
     */
    public Add addStringOperation(ScrabbleString sString, OperableEntity operableEntity){
        return new Add(StringFactory.getConstant(sString),
                operableEntity);
    }

    /**
     * Returns an arithmetic operation between a ScrabbleFloat and a ScrabbleBinary
     * @param sfloat a ScrabbleFloat
     * @param sbin a ScrabbleBinary
     * @param factory an arithmetic operation factory
     * @return the operation
     */
    public ArithmeticOperation operateFloatWithBin(ScrabbleFloat sfloat, ScrabbleBinary sbin,
                                                   ArithmeticOperationFactory factory){
        return factory.create(FloatFactory.getConstant(sfloat),
                BinFactory.getConstant(sbin));
    }

    /**
     * Returns an arithmetic operation between a ScrabbleFloat and a ScrabbleInt
     * @param sfloat a ScrabbleFloat
     * @param sint a ScrabbleInt
     * @param factory an arithmetic operation factory
     * @return the operation
     */
    public ArithmeticOperation operateFloatWithInt(ScrabbleFloat sfloat, ScrabbleInt sint,
                                                   ArithmeticOperationFactory factory){
        return factory.create(FloatFactory.getConstant(sfloat),
                IntFactory.getConstant(sint));
    }

    /**
     * Returns an arithmetic operation between a ScrabbleFloat and a ScrabbleFloat
     * @param sfloat1 a ScrabbleFloat
     * @param sfloat2 a ScrabbleFloat
     * @param factory an arithmetic operation factory
     * @return the operation
     */
    public ArithmeticOperation operateFloatWithFloat(ScrabbleFloat sfloat1, ScrabbleFloat sfloat2,
                                                   ArithmeticOperationFactory factory){
        return factory.create(FloatFactory.getConstant(sfloat1),
                FloatFactory.getConstant(sfloat2));
    }

    /**
     * Returns an arithmetic operation between a ScrabbleInt and a ScrabbleFloat
     * @param sint a ScrabbleInt
     * @param sfloat a ScrabbleFloat
     * @param factory an arithmetic operation factory
     * @return the operation
     */
    public ArithmeticOperation operateIntWithFloat(ScrabbleInt sint, ScrabbleFloat sfloat,
                                                   ArithmeticOperationFactory factory){
        return factory.create(IntFactory.getConstant(sint),
                FloatFactory.getConstant(sfloat));
    }

    /**
     * Returns an arithmetic operation between a ScrabbleInt and a ScrabbleBinary
     * @param sint a ScrabbleInt
     * @param sbin a ScrabbleBinary
     * @param factory an arithmetic operation factory
     * @return the operation
     */
    public ArithmeticOperation operateIntWithBin(ScrabbleInt sint, ScrabbleBinary sbin,
                                                   ArithmeticOperationFactory factory){
        return factory.create(IntFactory.getConstant(sint),
                BinFactory.getConstant(sbin));
    }

    /**
     * Returns an arithmetic operation between a ScrabbleInt and a ScrabbleInt
     * @param sint1 a ScrabbleInt
     * @param sint2 a ScrabbleBinary
     * @param factory an arithmetic operation factory
     * @return the operation
     */
    public ArithmeticOperation operateIntWithInt(ScrabbleInt sint1, ScrabbleInt sint2,
                                                 ArithmeticOperationFactory factory){
        return factory.create(IntFactory.getConstant(sint1),
                IntFactory.getConstant(sint2));
    }

    /**
     * Returns an arithmetic operation between a ScrabbleBinary and a ScrabbleInt
     * @param sbin a ScrabbleInt
     * @param sint a ScrabbleBinary
     * @param factory an arithmetic operation factory
     * @return the operation
     */
    public ArithmeticOperation operateBinWithInt(ScrabbleBinary sbin, ScrabbleInt sint,
                                                     ArithmeticOperationFactory factory){
        return factory.create(BinFactory.getConstant(sbin),
                IntFactory.getConstant(sint));
    }


    /**
     * Returns an arithmetic operation between a ScrabbleBinary and a ScrabbleBinary
     * @param sbin1 a ScrabbleInt
     * @param sbin2 a ScrabbleBinary
     * @param factory an arithmetic operation factory
     * @return the operation
     */
    public ArithmeticOperation operateBinWithBin(ScrabbleBinary sbin1, ScrabbleBinary sbin2,
                                                 ArithmeticOperationFactory factory){
        return factory.create(BinFactory.getConstant(sbin1),
                BinFactory.getConstant(sbin2));
    }

    /**
     * Returns a logical operation between a ScrabbleBinary and a ScrabbleBool
     * @param sbin a ScrabbleBinary
     * @param sbool a ScrabbleBool
     * @param factory an arithmetic operation factory
     * @return the operation
     */
    public LogicalOperation logicOpBinWithBool(ScrabbleBinary sbin, ScrabbleBool sbool,
                                               LogicalOperationFactory factory){
        return factory.create(BinFactory.getConstant(sbin),
                BoolFactory.getConstant(sbool));
    }

    /**
     * Returns a logical operation between a ScrabbleBinary and a ScrabbleBinary
     * @param sbin1 a ScrabbleBinary
     * @param sbin2 a ScrabbleBinary
     * @param factory an arithmetic operation factory
     * @return the operation
     */
    public LogicalOperation logicOpBinWithBin(ScrabbleBinary sbin1, ScrabbleBinary sbin2,
                                               LogicalOperationFactory factory){
        return factory.create(BinFactory.getConstant(sbin1),
                BinFactory.getConstant(sbin2));
    }

    /**
     * Returns a logical operation between a ScrabbleBool and a ScrabbleBinary
     * @param sbool a ScrabbleBool
     * @param sbin a ScrabbleBinary
     * @param factory an arithmetic operation factory
     * @return the operation
     */
    public LogicalOperation logicOpBoolWithBin(ScrabbleBool sbool, ScrabbleBinary sbin,
                                              LogicalOperationFactory factory){
        return factory.create(BoolFactory.getConstant(sbool),
                BinFactory.getConstant(sbin));
    }

    /**
     * Returns a logical operation between a ScrabbleBool and a ScrabbleBool
     * @param sbool1 a ScrabbleBool
     * @param sbool2 a ScrabbleBool
     * @param factory an arithmetic operation factory
     * @return the operation
     */
    public LogicalOperation logicOpBoolWithBool(ScrabbleBool sbool1, ScrabbleBool sbool2,
                                               LogicalOperationFactory factory){
        return factory.create(BoolFactory.getConstant(sbool1),
                BoolFactory.getConstant(sbool2));
    }

    /**
     * Returns a logical negation operation to a ScrabbleBool
     * @param sbool a ScrabbleBool
     * @return the operation
     */
    public LogicalOperation negateBool(ScrabbleBool sbool){
        return new Not(BoolFactory.getConstant(sbool));
    }

    /**
     * Returns a logical negation operation to a ScrabbleBinary
     * @param sbin a ScrabbleBinary
     * @return the operation
     */
    public LogicalOperation negateBin(ScrabbleBinary sbin){
        return new Not(BinFactory.getConstant(sbin));
    }
}