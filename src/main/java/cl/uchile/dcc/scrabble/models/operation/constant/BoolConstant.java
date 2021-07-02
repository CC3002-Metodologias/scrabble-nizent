package cl.uchile.dcc.scrabble.models.operation.constant;

import cl.uchile.dcc.scrabble.models.operation.constantFactory.BinFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.BoolFactory;
import cl.uchile.dcc.scrabble.models.operation.constantFactory.StringFactory;
import cl.uchile.dcc.scrabble.models.type.ScrabbleBool;
import cl.uchile.dcc.scrabble.models.type.ScrabbleInt;

public class BoolConstant extends AbstractConstant {
    private final ScrabbleBool value;

    public BoolConstant(ScrabbleBool value){
        this.value = value;
    }

    public ScrabbleBool value() {
        return new ScrabbleBool(this.value.value());
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof BoolConstant){
            BoolConstant boolConstant = (BoolConstant) obj;
            return boolConstant.value().equals(this.value);
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.value.hashCode();
    }

    @Override
    public Constant andToBin(BinConstant binConstant) {
        return BinFactory.getConstant(this.value.andBinary(binConstant.value()));
    }

    @Override
    public Constant addToString(StringConstant stringConstant) {
        return StringFactory.getConstant(stringConstant.value().sum(this.value));
    }

    @Override
    public Constant orToBin(BinConstant binConstant) {
        return BinFactory.getConstant(this.value.orBinary(binConstant.value()));
    }

    @Override
    public Constant orToBool(BoolConstant boolConstant) {
        return BoolFactory.getConstant(this.value.orBool(boolConstant.value()));
    }

    @Override
    public Constant andToBool(BoolConstant boolConstant) {
        return BoolFactory.getConstant(this.value.andBool(boolConstant.value()));
    }

    @Override
    public Constant and(Constant constant){
        return constant.andToBool(this);
    }

    @Override
    public Constant or(Constant constant){
        return constant.orToBool(this);
    }

    @Override
    public Constant negate(){
        return BoolFactory.getConstant(this.value.negate());
    }
}
