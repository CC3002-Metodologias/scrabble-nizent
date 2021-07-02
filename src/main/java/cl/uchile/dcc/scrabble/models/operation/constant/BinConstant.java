package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constantFactory.BinFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.FloatFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.IntFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.StringFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;

public class BinConstant extends AbstractConstant {
    private final ScrabbleBinary value;

    public BinConstant(ScrabbleBinary value) {
        this.value = value;
    }

    public ScrabbleBinary value() {
        return new ScrabbleBinary(this.value.value());
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof BinConstant){
            BinConstant binConstant = (BinConstant) obj;
            return binConstant.value().equals(this.value);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.value.hashCode();
    }

    @Override
    public Constant addToBin(BinConstant binConstant){
        return BinFactory.getConstant(binConstant.value().
                sum(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant addToString(StringConstant stringConstant){
        return StringFactory.getConstant(stringConstant.value().sum(this.value));
    }

    @Override
    public Constant add(Constant constant){
        return constant.addToBin(this);
    }

    @Override
    public Constant subToBin(BinConstant binConstant){
        return BinFactory.getConstant(binConstant.value().
                subtract(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant sub(Constant constant){
        return constant.subToBin(this);
    }

    @Override
    public Constant multToBin(BinConstant binConstant){
        return BinFactory.getConstant(binConstant.value().
                multiplyBy(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant mult(Constant constant){
        return constant.multToBin(this);
    }

    @Override
    public Constant divToBin(BinConstant binConstant){
        return BinFactory.getConstant(binConstant.value().
                divideBy(this.value).transformToScrabbleBinary());
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
        return FloatFactory.getConstant(this.value.sumToFloat(floatConstant.value()).transformToScrabbleFloat());
    }

    @Override
    public Constant subToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.subtractToFloat(floatConstant.value()).transformToScrabbleFloat());
    }

    @Override
    public Constant multToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.multiplyToFloat(floatConstant.value()).transformToScrabbleFloat());
    }

    @Override
    public Constant divToFloat(FloatConstant floatConstant) {
        return FloatFactory.getConstant(this.value.divideToFloat(floatConstant.value()).transformToScrabbleFloat());
    }

    @Override
    public Constant div(Constant constant){
        return constant.divToBin(this);
    }

    @Override
    public Constant andToBin(BinConstant binConstant){
        return BinFactory.getConstant(binConstant.value().
                and(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant andToBool(BoolConstant boolConstant){
        return BinFactory.getConstant(this.value.andBool(boolConstant.value()));
    }

    @Override
    public Constant and(Constant constant){
        return constant.andToBin(this);
    }

    @Override
    public Constant orToBin(BinConstant binConstant){
        return BinFactory.getConstant(binConstant.value().
                or(this.value));
    }

    @Override
    public Constant orToBool(BoolConstant boolConstant){
        return BinFactory.getConstant(this.value.orBool(boolConstant.value()));
    }

    @Override
    public Constant or(Constant constant){
        return constant.orToBin(this);
    }

    @Override
    public Constant negate(){
        return BinFactory.getConstant(this.value.negate());
    }
}