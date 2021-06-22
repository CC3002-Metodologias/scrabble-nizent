package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;

public class FloatConstant extends AbstractConstant{
    private ScrabbleFloat value;

    public FloatConstant(ScrabbleFloat value){
        this.value = value;
    }

    public ScrabbleFloat value(){
        return this.value;
    }

    @Override
    public Constant add(Constant constant) {
        return constant.addToFloat(this);
    }

    @Override
    public Constant div(Constant evaluate) {
        return evaluate.divToFloat(this);
    }

    @Override
    public Constant mult(Constant evaluate) {
        return evaluate.multToFloat(this);
    }

    @Override
    public Constant sub(Constant evaluate) {
        return evaluate.subToFloat(this);
    }

    @Override
    public Constant addToString(StringConstant stringConstant) {
        return new StringConstant(stringConstant.value().sum(this.value));
    }

    @Override
    public Constant addToInt(IntConstant intConstant) {
        return new FloatConstant(this.value.sumToInt(intConstant.value()));
    }

    @Override
    public Constant subToInt(IntConstant intConstant) {
        return new FloatConstant(this.value.subtractToInt(intConstant.value()));
    }

    @Override
    public Constant multToInt(IntConstant intConstant) {
        return new FloatConstant(this.value.multiplyToInt(intConstant.value()));
    }

    @Override
    public Constant divToInt(IntConstant intConstant) {
        return new FloatConstant(this.value.divideToInt(intConstant.value()));
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
        return new FloatConstant(this.value);
    }
}
