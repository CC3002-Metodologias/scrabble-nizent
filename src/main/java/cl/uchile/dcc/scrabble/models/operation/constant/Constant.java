package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.OperableEntity;
import cl.uchile.dcc.scrabble.models.type.IType;

public interface Constant extends OperableEntity {
    Constant add(Constant constant);
    Constant div(Constant evaluate);
    Constant mult(Constant evaluate);
    Constant sub(Constant evaluate);
    Constant and(Constant constant);
    Constant or(Constant constant);
    Constant negate();

    Constant addToString(StringConstant stringConstant);

    Constant addToBin(BinConstant binConstant);
    Constant subToBin(BinConstant binConstant);
    Constant multToBin(BinConstant binConstant);
    Constant divToBin(BinConstant binConstant);

    Constant addToInt(IntConstant intConstant);
    Constant subToInt(IntConstant intConstant);
    Constant multToInt(IntConstant intConstant);
    Constant divToInt(IntConstant intConstant);


    Constant addToFloat(FloatConstant floatConstant);
    Constant subToFloat(FloatConstant floatConstant);
    Constant multToFloat(FloatConstant floatConstant);
    Constant divToFloat(FloatConstant floatConstant);

    Constant andToBin(BinConstant binConstant);
    Constant orToBin(BinConstant binConstant);
    Constant orToBool(BoolConstant boolConstant);
    Constant andToBool(BoolConstant boolConstant);
}