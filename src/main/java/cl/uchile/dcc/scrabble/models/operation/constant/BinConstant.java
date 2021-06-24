package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.type.IInteger;
import cl.uchile.dcc.scrabble.models.type.IType;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBinary;

public class BinConstant extends AbstractConstant {
    private ScrabbleBinary value;

    public BinConstant(ScrabbleBinary value) {
        this.value = value;
    }

    public ScrabbleBinary value() {
        return this.value;
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
        return new BinConstant(binConstant.value().
                sum(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant addToString(StringConstant stringConstant){
        return new StringConstant(stringConstant.value().sum(this.value));
    }

    @Override
    public Constant add(Constant constant){
        return constant.addToBin(this);
    }

    @Override
    public Constant subToBin(BinConstant binConstant){
        return new BinConstant(binConstant.value().
                subtract(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant sub(Constant constant){
        return constant.subToBin(this);
    }

    @Override
    public Constant multToBin(BinConstant binConstant){
        return new BinConstant(binConstant.value().
                multiplyBy(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant mult(Constant constant){
        return constant.multToBin(this);
    }

    @Override
    public Constant divToBin(BinConstant binConstant){
        return new BinConstant(binConstant.value().
                divideBy(this.value).transformToScrabbleBinary());
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
        return new FloatConstant(this.value.sumToFloat(floatConstant.value()).transformToScrabbleFloat());
    }

    @Override
    public Constant subToFloat(FloatConstant floatConstant) {
        return new FloatConstant(this.value.subtractToFloat(floatConstant.value()).transformToScrabbleFloat());
    }

    @Override
    public Constant multToFloat(FloatConstant floatConstant) {
        return new FloatConstant(this.value.multiplyToFloat(floatConstant.value()).transformToScrabbleFloat());
    }

    @Override
    public Constant divToFloat(FloatConstant floatConstant) {
        return new FloatConstant(this.value.divideToFloat(floatConstant.value()).transformToScrabbleFloat());
    }

    @Override
    public Constant div(Constant constant){
        return constant.divToBin(this);
    }

    @Override
    public Constant andToBin(BinConstant binConstant){
        return new BinConstant(binConstant.value().
                and(this.value).transformToScrabbleBinary());
    }

    @Override
    public Constant andToBool(BoolConstant boolConstant){
        return new BinConstant(this.value.andBool(boolConstant.value()));
    }

    @Override
    public Constant and(Constant constant){
        return constant.andToBin(this);
    }

    @Override
    public Constant orToBin(BinConstant binConstant){
        return new BinConstant(binConstant.value().
                or(this.value));
    }

    @Override
    public Constant orToBool(BoolConstant boolConstant){
        return new BinConstant(this.value.orBool(boolConstant.value()));
    }

    @Override
    public Constant or(Constant constant){
        return constant.orToBin(this);
    }

    @Override
    public Constant negate(){
        return new BinConstant(this.value.negate());
    }

    @Override
    public Constant evaluate(){
        return new BinConstant(this.value);
    }
}