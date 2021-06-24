package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;

public class IntConstant extends AbstractConstant{
    private ScrabbleInt value;

    public IntConstant(ScrabbleInt value){
        this.value = value;
    }

    public ScrabbleInt value(){
        return this.value;
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
        return new StringConstant(stringConstant.value().sum(this.value));
    }

    @Override
    public Constant addToBin(BinConstant binConstant) {
        return new BinConstant(binConstant.value().sum(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant subToBin(BinConstant binConstant) {
        return new BinConstant(binConstant.value().subtract(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant multToBin(BinConstant binConstant) {
        return new BinConstant(binConstant.value().multiplyBy(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant divToBin(BinConstant binConstant) {
        return new BinConstant(binConstant.value().divideBy(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant addToInt(IntConstant intConstant) {
        return new IntConstant(this.value.sumToInt(intConstant.value()));
    }

    @Override
    public Constant subToInt(IntConstant intConstant) {
        return new IntConstant(this.value.subtractToInt(intConstant.value()));
    }

    @Override
    public Constant multToInt(IntConstant intConstant) {
        return new IntConstant(this.value.multiplyToInt(intConstant.value()));
    }

    @Override
    public Constant divToInt(IntConstant intConstant) {
        return new IntConstant(this.value.divideToInt(intConstant.value()));
    }

    @Override
    public Constant addToFloat(FloatConstant floatConstant) {
        return new FloatConstant(this.value.sumToFloat(floatConstant.value()));
    }

    @Override
    public Constant subToFloat(FloatConstant floatConstant) {
        return new FloatConstant(this.value.subtractToFloat(floatConstant.value()));
    }

    @Override
    public Constant multToFloat(FloatConstant floatConstant) {
        return new FloatConstant(this.value.multiplyToFloat(floatConstant.value()));
    }

    @Override
    public Constant divToFloat(FloatConstant floatConstant) {
        return new FloatConstant(this.value.divideToFloat(floatConstant.value()));
    }

    @Override
    public Constant evaluate() {
        return new IntConstant(this.value);
    }
}
