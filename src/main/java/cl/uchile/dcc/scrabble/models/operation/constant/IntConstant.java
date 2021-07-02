package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constantFactory.BinFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.FloatFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.IntFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.StringFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;

public class IntConstant extends AbstractConstant{
    private ScrabbleInt value;

    public IntConstant(ScrabbleInt value){
        this.value = value;
    }

    public ScrabbleInt value(){
        return new ScrabbleInt(this.value.value());
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof IntConstant){
            IntConstant intConstant = (IntConstant) obj;
            return intConstant.value().equals(this.value);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.value.hashCode();
    }

    @Override
    public Constant add(Constant constant) {
        return constant.addToInt(this);
    }

    @Override
    public Constant div(Constant evaluate) {
        return evaluate.divToInt(this);
    }

    @Override
    public Constant mult(Constant evaluate) {
        return evaluate.multToInt(this);
    }

    @Override
    public Constant sub(Constant evaluate) {
        return evaluate.subToInt(this);
    }

    @Override
    public Constant addToString(StringConstant stringConstant) {
        return StringFactory.getConstant(stringConstant.value().sum(this.value));
    }

    @Override
    public Constant addToBin(BinConstant binConstant) {
        return BinFactory.getConstant(binConstant.value().sum(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant subToBin(BinConstant binConstant) {
        return BinFactory.getConstant(binConstant.value().subtract(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant multToBin(BinConstant binConstant) {
        return BinFactory.getConstant(binConstant.value().multiplyBy(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant divToBin(BinConstant binConstant) {
        return BinFactory.getConstant(binConstant.value().divideBy(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant addToInt(IntConstant intConstant) {
        return IntFactory.getConstant(this.value.sumToInt(intConstant.value()));
    }

    @Override
    public Constant subToInt(IntConstant intConstant) {
        return IntFactory.getConstant(this.value.subtractToInt(intConstant.value()));
    }

    @Override
    public Constant multToInt(IntConstant intConstant) {
        return IntFactory.getConstant(this.value.multiplyToInt(intConstant.value()));
    }

    @Override
    public Constant divToInt(IntConstant intConstant) {
        return IntFactory.getConstant(this.value.divideToInt(intConstant.value()));
    }

    @Override
    public Constant addToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.sumToFloat(floatConstant.value()));
    }

    @Override
    public Constant subToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.subtractToFloat(floatConstant.value()));
    }

    @Override
    public Constant multToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.multiplyToFloat(floatConstant.value()));
    }

    @Override
    public Constant divToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.divideToFloat(floatConstant.value()));
    }
}