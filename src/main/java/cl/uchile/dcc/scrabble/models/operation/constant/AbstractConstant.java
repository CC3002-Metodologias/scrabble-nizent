package cl.uchile.dcc.scrabble.models.operation.constant;

public abstract class AbstractConstant implements Constant {

    @Override
    public Constant add(Constant constant) {
        return null;
    }

    @Override
    public Constant div(Constant evaluate) {
        return null;
    }

    @Override
    public Constant mult(Constant evaluate) {
        return null;
    }

    @Override
    public Constant sub(Constant evaluate) {
        return null;
    }

    @Override
    public Constant and(Constant constant) {
        return null;
    }

    @Override
    public Constant or(Constant constant) {
        return null;
    }

    @Override
    public Constant negate() {
        return null;
    }

    @Override
    public Constant addToString(StringConstant stringConstant) {
        return null;
    }

    @Override
    public Constant addToBin(BinConstant binConstant) {
        return null;
    }

    @Override
    public Constant subToBin(BinConstant binConstant) {
        return null;
    }

    @Override
    public Constant multToBin(BinConstant binConstant) {
        return null;
    }

    @Override
    public Constant divToBin(BinConstant binConstant) {
        return null;
    }

    @Override
    public Constant addToInt(IntConstant intConstant) {
        return null;
    }

    @Override
    public Constant subToInt(IntConstant intConstant) {
        return null;
    }

    @Override
    public Constant multToInt(IntConstant intConstant) {
        return null;
    }

    @Override
    public Constant divToInt(IntConstant intConstant) {
        return null;
    }

    @Override
    public Constant addToFloat(FloatConstant floatConstant) {
        return null;
    }

    @Override
    public Constant subToFloat(FloatConstant floatConstant) {
        return null;
    }

    @Override
    public Constant multToFloat(FloatConstant floatConstant) {
        return null;
    }

    @Override
    public Constant divToFloat(FloatConstant floatConstant) {
        return null;
    }

    @Override
    public Constant andToBin(BinConstant binConstant) {
        return null;
    }

    @Override
    public Constant orToBin(BinConstant binConstant) {
        return null;
    }

    @Override
    public Constant orToBool(BoolConstant boolConstant) {
        return null;
    }

    @Override
    public Constant andToBool(BoolConstant boolConstant) {
        return null;
    }

    @Override
    public Constant evaluate() {
        return this;
    }
}
