package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constantFactory.FloatFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.StringFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleFloat;

public class FloatConstant extends AbstractConstant{
    private final ScrabbleFloat value;

    public FloatConstant(ScrabbleFloat value){
        this.value = value;
    }

    public ScrabbleFloat value(){
        return new ScrabbleFloat(this.value.value());
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof FloatConstant){
            FloatConstant floatConstant = (FloatConstant) obj;
            return floatConstant.value().equals(this.value);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.value.hashCode();
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
        return StringFactory.getConstant(stringConstant.value().sum(this.value));
    }

    @Override
    public Constant addToInt(IntConstant intConstant) {
        return FloatFactory.getConstant(this.value.sumToInt(intConstant.value()));
    }

    @Override
    public Constant subToInt(IntConstant intConstant) {
        return FloatFactory.getConstant(this.value.subtractToInt(intConstant.value()));
    }

    @Override
    public Constant multToInt(IntConstant intConstant) {
        return FloatFactory.getConstant(this.value.multiplyToInt(intConstant.value()));
    }

    @Override
    public Constant divToInt(IntConstant intConstant) {
        return FloatFactory.getConstant(this.value.divideToInt(intConstant.value()));
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

    @Override
    public String toString(){
        return "SFloat(" +this.value.toString()+ ")";
    }
}