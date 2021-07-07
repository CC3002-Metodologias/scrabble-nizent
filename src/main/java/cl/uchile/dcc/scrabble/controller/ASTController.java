package cl.uchile.dcc.scrabble.controller;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.operation.Operation;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.Add;
import cl.uchile.dcc.scrabble.models.operation.arithmetic.ArithmeticOperation;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.*;
import cl.uchile.dcc.scrabble.models.operation.logical.LogicalOperation;
import cl.uchile.dcc.scrabble.models.operation.logical.Not;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.ArithmeticOperationFactory;
import cl.uchile.dcc.scrabble.models.operation.operationFactory.LogicalOperationFactory;
import cl.uchile.dcc.scrabble.models.type.*;

import java.util.ArrayList;
import java.util.List;

public class ASTController {
    private final List<OperableEntity> operations = new ArrayList<>();

    public Add addStringOperation(ScrabbleString sString, OperableEntity operation){
        return new Add(StringFactory.getConstant(sString),
                operation);
    }

    public ArithmeticOperation operateFloatWithBin(ScrabbleFloat sfloat, ScrabbleBinary sbin,
                                                   ArithmeticOperationFactory factory){
        return factory.create(FloatFactory.getConstant(sfloat),
                BinFactory.getConstant(sbin));
    }

    public ArithmeticOperation operateFloatWithInt(ScrabbleFloat sfloat, ScrabbleInt sint,
                                                   ArithmeticOperationFactory factory){
        return factory.create(FloatFactory.getConstant(sfloat),
                IntFactory.getConstant(sint));
    }

    public ArithmeticOperation operateFloatWithFloat(ScrabbleFloat sfloat1, ScrabbleFloat sfloat2,
                                                   ArithmeticOperationFactory factory){
        return factory.create(FloatFactory.getConstant(sfloat1),
                FloatFactory.getConstant(sfloat2));
    }

    public ArithmeticOperation operateIntWithFloat(ScrabbleInt sint, ScrabbleFloat sfloat,
                                                   ArithmeticOperationFactory factory){
        return factory.create(IntFactory.getConstant(sint),
                FloatFactory.getConstant(sfloat));
    }

    public ArithmeticOperation operateIntWithBin(ScrabbleInt sint, ScrabbleBinary sbin,
                                                   ArithmeticOperationFactory factory){
        return factory.create(IntFactory.getConstant(sint),
                BinFactory.getConstant(sbin));
    }

    public ArithmeticOperation operateIntWithInt(ScrabbleInt sint1, ScrabbleInt sint2,
                                                 ArithmeticOperationFactory factory){
        return factory.create(IntFactory.getConstant(sint1),
                IntFactory.getConstant(sint2));
    }

    public ArithmeticOperation operateBinWithInt(ScrabbleBinary sbin, ScrabbleInt sint,
                                                     ArithmeticOperationFactory factory){
        return factory.create(BinFactory.getConstant(sbin),
                IntFactory.getConstant(sint));
    }

    public ArithmeticOperation operateBinWithBin(ScrabbleBinary sbin1, ScrabbleBinary sbin2,
                                                 ArithmeticOperationFactory factory){
        return factory.create(BinFactory.getConstant(sbin1),
                BinFactory.getConstant(sbin2));
    }

    public LogicalOperation logicOpBinWithBool(ScrabbleBinary sbin, ScrabbleBool sbool,
                                               LogicalOperationFactory factory){
        return factory.create(BinFactory.getConstant(sbin),
                BoolFactory.getConstant(sbool));
    }

    public LogicalOperation logicOpBinWithBin(ScrabbleBinary sbin1, ScrabbleBinary sbin2,
                                               LogicalOperationFactory factory){
        return factory.create(BinFactory.getConstant(sbin1),
                BinFactory.getConstant(sbin2));
    }

    public LogicalOperation logicOpBoolWithBin(ScrabbleBool sbool, ScrabbleBinary sbin,
                                              LogicalOperationFactory factory){
        return factory.create(BoolFactory.getConstant(sbool),
                BinFactory.getConstant(sbin));
    }

    public LogicalOperation logicOpBoolWithBool(ScrabbleBool sbool1, ScrabbleBool sbool2,
                                               LogicalOperationFactory factory){
        return factory.create(BoolFactory.getConstant(sbool1),
                BoolFactory.getConstant(sbool2));
    }

    public LogicalOperation negateBool(ScrabbleBool sbool){
        return new Not(BoolFactory.getConstant(sbool));
    }

    public LogicalOperation negateBin(ScrabbleBinary sbin){
        return new Not(BinFactory.getConstant(sbin));
    }
}
